<template>
  <div>
  <div id="container">
    
    <GmapMap
      id="map"
      ref="map"
      :center="{ lat: $store.state.coordinates.lat, lng: $store.state.coordinates.lng }"
      :zoom="12"
      style="width: 100%; height: 500px"
    >
    
      <gmap-marker
        class="marker"
        :position="{ lat: $store.state.coordinates.lat, lng: $store.state.coordinates.lng }"
        :icon="'http://maps.google.com/mapfiles/ms/micons/yellow-dot.png'"
        :clickable="true"
        :draggable="false"
      ></gmap-marker>
      <gmap-marker
        v-for="shop in $store.state.shops"
        :key="shop.shopId"
        :position="{
          lat: parseFloat(shop.latitude),
          lng: parseFloat(shop.longitude),
        }"
        :icon="'http://maps.google.com/mapfiles/ms/micons/red-dot.png'"
        :clickable="true"
        :draggable="false"
        v-on:click="setActiveShop(shop), $emit('opensidebar')/* , openWindow(shop) */"
      >
       <!--  <gmap-info-window
          :key="shop.shopId"
          :options="infoWindowOptions"
          :position="infoWindowPosition"
          :opened="toggleInfoWindow"
        >
          <div class="info-wind">
            <h2>{{ $store.state.activeShop.shop }}</h2>
            <p>{{ $store.state.activeShop.address }}</p>
          </div>
        </gmap-info-window> -->
      </gmap-marker>
    </GmapMap>
    <div id="sidebar"></div>
  </div>
</div>
</template>

  <script>
export default {
  name: "Map",
  directionsService: null,
  directionsDisplay: null,
  data() {
    return {
/*       coordinates: {
        lat: 0,
        lng: 0,
      }, */
      infoWindowOptions: {
        pixelOffset: {
          width: 0,
          height: 0,
        }
      },
      toggleInfoWindow: false,
    };
  },
  methods: {
    setActiveShop(shop) {
      return this.$store.commit("SET_ACTIVE_SHOP", shop);
    },
    loadDirections() {
      if(this.directionsRenderer){
        this.directionsRenderer.setMap(null)
        this.directionsRenderer.setPanel(null)
      }
      const directionsService = new window.google.maps.DirectionsService();
      this.directionsRenderer = new window.google.maps.DirectionsRenderer();
      this.directionsRenderer.setMap(this.$refs.map.$mapObject);
      this.directionsRenderer.setPanel(document.getElementById("sidebar"));
      this.calculateAndDisplayRoute(directionsService, this.directionsRenderer);
    },

    calculateAndDisplayRoute(directionsService, directionsRenderer) {
      const origin = { lat: this.$store.state.coordinates.lat, lng: this.$store.state.coordinates.lng };
      const destination = this.$store.state.activeShop.address;
      console.log(origin, destination);
      directionsService
        .route({
          origin: origin,
          destination: destination,
          travelMode: window.google.maps.TravelMode.DRIVING,
        })
        .then((response) => {
          directionsRenderer.setDirections(response);
        })
        .catch((error) => alert(error));
    },
    clearDirections(){
      this.directionsRenderer.setMap(null)
      this.directionsRenderer.setPanel(null)
    }
  },
   /*  openWindow(shop){
      this.toggleInfoWindow = this.toggleInfoWindow === shop.shopId ? null : shop.shopId;
    } */
  computed: {
    runLoadDirections(){
      return this.$store.state.isGetDirections;
    },
    runClearDirections(){
      return this.$store.state.isClearDirections;
    },
    infoWindowPostions() {
      return {
        lat: parseFloat(this.$store.state.activeShop.latitude),
        lng: parseFloat(this.$store.state.activeShop.longitude),
      };
    },
  },
  watch: {
      runLoadDirections: function(val) {
        if(val == true){
        this.loadDirections();
        this.$store.commit('SET_DIRECTIONS');
      }
      },
      runClearDirections: function(val){
        if(val == true ){
        this.clearDirections();
        this.$store.commit('CLEAR_DIRECTIONS');
        }
      }
  },
  created() {
    this.$getLocation({})

      .then((coordinates) => {
        this.$store.commit("SET_COORDINATES", coordinates)
      })
      .catch((error) => alert(error));
  },
};
</script>
  
  <style>
.marker {
  width: 5px;
  height: auto;
}
#container{
  height: 500px;
  display: flex;
}

#sidebar {
  flex-basis: 15rem;
  flex-grow: 1;
  padding: 1rem;
  max-width: 30rem;
  height: 100%;
  box-sizing: border-box;
  overflow: auto;
  background-color: aliceblue;
}

#sidebar {
  flex: 0 1 auto;
  padding: 0;
}
#sidebar > div {
  padding: 0.5rem;
}
</style>