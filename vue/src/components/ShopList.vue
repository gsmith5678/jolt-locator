<template>
  <div>

    <div>
     <!--  <img v-if="isFilterList" class="image" src="../assets/generic1.png" alt="" />
      <img v-if="!isFilterList" class="image" src="../assets/generic2.png" alt="" /> -->
    </div>
    <div id="nav-buttons">
    <!--   <button v-if="!isFilterList" @click="isFilterList = !isFilterList" class="filter-favorites">Filter Favorites</button>
      <button v-if="isFilterList" @click="isFilterList = !isFilterList" class="filter-favorites">List All Shops</button> -->
 
      <!-- this is where the direction button lived -->
    </div>

    <h1 id="coffee-shops-header" class="fancy-text bottom-border">Coffee Shops</h1>
  <div class="shoplistHolder">
    <div class="shoplistImages">
      <img src="../assets/generic6.png" alt="">
      <img src="../assets/generic8.png" alt="">

    </div>

    <div class="shoplist">
      <div v-for="shop in getList()" v-bind:key="shop.id">
        <div
          class="shop"
          v-on:click.prevent="setActiveShop(shop), $emit('opensidebar')"
        >
          {{ shop.shop + " ~ "}}
          <img
        id="rating2"
        class="highlights"
        src="../assets/Beans_Artwork.png"
        alt=""
        title="Positive rating bean"
        v-for="numberOfRating in shop.rating"
        v-bind:key="numberOfRating"
      />
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import ShopService from "../services/ShopService.js";
export default {
  name: "shop-list",

  data() {
    return {
      /* favoritesList: [],
      visitedList: [], */
      isFilterList: false,
      isFilterRating: false,
      selectedValue: '',
    };
  },
  
  methods: {
    getDistanceBetweenPoints(latitude1, longitude1, latitude2, longitude2, unit = 'miles') {
    let theta = longitude1 - longitude2;
    let distance = 60 * 1.1515 * (180/Math.PI) * Math.acos(
        Math.sin(latitude1 * (Math.PI/180)) * Math.sin(latitude2 * (Math.PI/180)) + 
        Math.cos(latitude1 * (Math.PI/180)) * Math.cos(latitude2 * (Math.PI/180)) * Math.cos(theta * (Math.PI/180))
    )
    if (unit == 'miles') {
        return Math.round(distance, 2);
    } else if (unit == 'kilometers') {
        return Math.round(distance * 1.609344, 2);
    }
    },

    methodToRunOnSelect(payload) {
            this.object = payload;
    },
    setActiveShop(shop) {
      return this.$store.commit("SET_ACTIVE_SHOP", shop);
    },
    getList() {
      ShopService.getFavoritesList()
      .then((response) => {
        this.$store.commit("SET_FAVORITES_LIST", response.data)
      })
      .catch((err) => console.error(err));

      ShopService.getVisitedList()
            .then((response) => {
              this.$store.commit('SET_VISITED_LIST', response.data)
            })
            .catch((err) => console.error(err));

      if ( this.$store.state.dropdownSelection == '') {
        return this.$store.state.shops;
      } else if (this.$store.state.dropdownSelection == 'filter-by-favorites') {
        return this.$store.state.shops.filter((shop) => {
          for (let i = 0; i < this.$store.state.favoritesList.length; i++) {
            let output = this.$store.state.favoritesList[i].shopId;
            if (shop.shopId == output) {
              return shop;
            }
          }
        })
      } else if(this.$store.state.dropdownSelection == 'filter-by-rating'){
        let outputArr = this.$store.state.shops; 
        return outputArr.sort((a, b)=>
            b.rating - a.rating
          )
      } else if(this.$store.state.dropdownSelection == 'filter-by-distance'){
        let inputArr = this.$store.state.shops; 
        for(let i = 0; i < inputArr.length; i++){
         inputArr[i].distance = this.getDistanceBetweenPoints(this.$store.state.coordinates.lat, this.$store.state.coordinates.lng, inputArr[i].latitude, inputArr[i].longitude, 'miles')
        }
        return inputArr.sort((a, b)=> a.distance - b.distance);
      } else if (this.$store.state.dropdownSelection == 'filter-by-visited') {
              return this.$store.state.shops.filter((shop) => {
                for (let i = 0; i < this.$store.state.visitedList.length; i++) {
                  let output = this.$store.state.visitedList[i].shopId;
                  if (shop.shopId == output) {
                    return shop;
                  }
                }
              })
           }

      },

      // getVisited() {
            
      // }
  
    },

  created() {
    ShopService.getShopsList()
      .then((response) => {
        this.$store.commit("SET_SHOPS", response.data);
      })
      .catch((err) => console.error(err));

    //pull in favorited list as a local var (optional) or come from store

    //created - make a call to get favorite list & ids
    //use it to filter in computed
    ShopService.getFavoritesList()
      .then((response) => {
        this.$store.commit("SET_FAVORITES_LIST", response.data)
      })
      .catch((err) => console.error(err));
  }
}
</script>

<style scoped>
.shoplistHolder {
  display: flex;
  column-gap: 10px;
}

.shoplistImages > img {
  width: 95%;
  margin-top: 5px;
}

.shoplistImages {
  width: 70%;
  flex-basis: 50rem;
}

.shoplist {
  display: flex;
  flex-direction: column;
  row-gap: 10px;
  padding-top: 10px;
  flex-basis: 70rem;
  max-height: 535px;
  overflow: auto;
}

.shop:hover {
  color: #683012;
  cursor: default;
}
.image {
  width: 80%;
  margin-bottom: 20px;
  margin-top: 20px;
  border-radius: 8px;
}
#nav-buttons {
  display: flex;
  justify-content: space-between;
  margin-top: 0px;
  margin-right: 10%;
  margin-left: 10%;
  margin-bottom: 20px;
}
.highlights{
  width: 20px;
}

.bottom-border{
  border-bottom: #242921 solid;
  border-width: 3px;
  padding-bottom: 5px;
}
#coffee-shop-header {
  padding-top: 0px;
}

@media screen and (max-width: 420px) {
  .shoplistImages > img {
    display: none;
  }

  .shoplistImages {
  width: 70%;
  flex-basis: 0rem;
}

}


</style>
