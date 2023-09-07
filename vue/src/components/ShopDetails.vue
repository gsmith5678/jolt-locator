<template>
  <div id="shopdetails">
    <div id="sidebar-img">
  
      <img :src="getImageURL(currentshop.image)" alt="coffee shop img" />
      <div id="buttons">
        <button @click="(favorited = !favorited), evaluateFavorited()">
          {{ displayIsFavorited() }} </button>
        <button @click="(checked = !checked), evaluatedVisited()">
          {{ displayVisited() }} </button>
      </div>
    </div>
    <div class="highlight-header, headers">Highlights:</div>
    <div>
      <img
        class="highlights"
        v-if="currentshop.highlights.includes('food')"
        src="../assets/food.png"
        alt=""
        title="Food available"
      />
      <img
        class="highlights"
        v-if="currentshop.highlights.includes('dessert')"
        src="../assets/desserts.png"
        alt=""
        title="Desserts available"
      />
      <img
        class="highlights"
        v-if="currentshop.highlights.includes('bean')"
        src="../assets/beans.png"
        alt=""
        title="Grounds available"
      />
      <img
        class="highlights"
        v-if="currentshop.highlights.includes('alcohol')"
        src="../assets/cocktail.png"
        alt=""
        title="Alcohol available"
      />
      <img
        class="highlights"
        v-if="currentshop.highlights.includes('smoothies')"
        src="../assets/smoothie.png"
        alt=""
        title="Smoothies available"
      />
      <img
        class="highlights"
        v-if="currentshop.highlights.includes('non-dairy')"
        src="../assets/dairy_free_2.png"
        alt=""
        title="Non-dairy options available"
      />
      <img
        class="highlights"
        v-if="currentshop.highlights.includes('outdoor seating')"
        src="../assets/terrace_1.png"
        alt=""
        title="Outdoor seating available"
      />
      <img
        class="highlights"
        v-if="currentshop.highlights.includes('dog friendly')"
        src="../assets/pet_friendly.png"
        alt=""
        title="Pet friendly"
      />
    </div>

    <div class="headers">Rating:</div>
    <div>
      <img
        id="rating"
        class="highlights"
        src="../assets/icons8-coffee-bean-48.png"
        alt=""
        title="Positive rating bean"
        v-for="numberOfRating in currentshop.rating"
        v-bind:key="numberOfRating"
      />
    </div>

    <div class="headers">Price:</div>
    <div>
      <img
        id="price"
        class="coffee-cups"
        src="../assets/icons8-coffee-cup-64.png"
        alt=""
        title="Overall price range"
        v-for="numberOfPrice in currentshop.price"
        v-bind:key="numberOfPrice"
      />
    </div>

    <div>
      <a href="">{{ currentshop.menulink }}</a>
    </div>
    <div>
      <div class="headers">Hours:</div>
      <ul class="hours">
        <li>
          <p>Monday:</p>
          <p>{{ currentshop.monday }}</p>
        </li>
        <li>
          <p>Tuesday:</p>
          <p>{{ currentshop.tuesday }}</p>
        </li>
        <li>
          <p>Wednesday:</p>
          <p>{{ currentshop.wednesday }}</p>
        </li>
        <li>
          <p>Thurday:</p>
          <p>{{ currentshop.thursday }}</p>
        </li>
        <li>
          <p>Friday:</p>
          <p>{{ currentshop.friday }}</p>
        </li>
        <li>
          <p>Saturday:</p>
          <p>{{ currentshop.saturday }}</p>
        </li>
        <li>
          <p>Sunday:</p>
          <p>{{ currentshop.sunday }}</p>
        </li>
      </ul>
    </div>
    <div class="headers">Address:</div>
    <div class="address">{{ currentshop.address }}</div>
    <div>
      <a v-bind:href="currentshop.webLink" target="_blank">
        <button class="weblink">Visit Our Website</button>
      </a>
    </div>
  </div>
</template>

<script>
import ShopService from "../services/ShopService";
export default {
  name: "shop-details",
  props: ["isSideBarOpen"],

  data() {
    return {
      checked: false,
      favorited: false,
    };
  },
  computed: {
    currentshop() {
      return this.$store.state.activeShop;
    },
    currentshopFavorited() {
      return this.$store.state.activeShop;
    },
  },
  watch: {
    currentshop: function (activeShop) {
      for (let i = 0; i < this.$store.state.visitedList.length; i++) {
        let output = this.$store.state.visitedList[i].shopId;
        if (output == activeShop.shopId) {
          return (this.checked = true);
        }
      }
      return (this.checked = false);
    },
    currentshopFavorited: function (activeShop) {
      for (let i = 0; i < this.$store.state.favoritesList.length; i++) {
        let output = this.$store.state.favoritesList[i].shopId;
        if (output == activeShop.shopId) {
          return (this.favorited = true);
        }
      }
      return (this.favorited = false);
    },
  },
  methods: {
    evaluatedVisited() {
      if (this.checked == true) {
        this.addVisitedShop();
      } else if (this.checked == false) {
        this.removeVisitedShop();
      }
    },
    evaluateFavorited() {
      if (this.favorited == true) {
        this.addFavoriteShop();
      } else if (this.favorited == false) {
        this.unfavoriteShop();
      }
    },
    displayVisited() {
      if (this.checked == true) {
        return "Un-Visit";
      } else {
        return "Visit";
      }
    },
    displayIsFavorited() {
      if (this.favorited == false) {
        return "Favorite";
      } else {
        return "Unfavorite";
      }
    },
    getImageURL(pic) {
      if(!pic.includes("http")){
              return require("../assets/" + pic);
      } else {
        return pic;
      }
    },
    addFavoriteShop() {
      let shopId = this.currentshop.shopId;
      ShopService.addFavorite(shopId);
    },
    unfavoriteShop() {
      let shopId = this.currentshop.shopId;
      ShopService.unFavorite(shopId);
    },
    addVisitedShop() {
      let shopId = this.currentshop.shopId;
      ShopService.addVisited(shopId);
    },
    removeVisitedShop() {
      let shopId = this.currentshop.shopId;
      ShopService.removeVisited(shopId);
    },
  },
};
</script>

<style scoped>
img {
  max-width: 100%;
  height: auto;
  border-radius: 8px;
}

#shopdetails {
  display: grid;
  grid-template-columns: auto;
  align-items: center;
}
#shopdetails > div {
  margin-top: 10px;
}

.hours > li {
  display: flex;
  list-style-type: none;
  text-align: center;
  align-items: center;
  justify-content: space-between;
  width: 76%;
  margin-left: 12%;
  margin-right: 12%;
}
.address {
  display: flex;
  text-align: center;
  justify-content: center;
  margin-right: 20%;
  margin-left: 20%;
  width: 60%;
  cursor: default;
}
.headers {
  text-decoration: underline;
  cursor: default;
  text-transform: uppercase;
  font-size: 1.7rem

}
.highlight-header {
  margin-bottom: 10px;
}
#buttons {
  margin-top: 10px;
}

#buttons > button {
  width: 127px;
  margin-right: 5px;
}

.button {
  box-shadow: 0 3px #666;
  color: black;
}
.button:active {
  box-shadow: 0 1px #666;
  background-color: white;
  transform: translateY(2px);
}
.highlights {
  width: 40px;
  padding-right: 10px;
}
.coffee-cups {
  width: 50px;
  padding-right: 10px;
}

</style>
