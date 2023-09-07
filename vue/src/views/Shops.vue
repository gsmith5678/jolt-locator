<template>
  <div>
    <div>
      <b-sidebar
        v-model="isSideBarOpen"
        id="sidebar-variant"
        bg-variant="dark"
        text-variant="light"
        aria-labelledby="sidebar-no-header-title"
        no-header
        shadow
      >
        <div class="px-3 py-2">
          <h1 id="sidebar-no-header-title">
            {{ this.$store.state.activeShop.shop }}
            <button
              @click="toggleSidebar()"
              type="button"
              aria-label="Close"
              class="close text-light"
            >
              <svg
                viewBox="0 0 16 16"
                width="2em"
                height="2em"
                focusable="false"
                role="img"
                aria-label="x"
                xmlns="http://www.w3.org/2000/svg"
                fill="currentColor"
                class="bi-x b-icon bi"
              >
                <g>
                  <path
                    d="M4.646 4.646a.5.5 0 0 1 .708 0L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 0 1 0-.708z"
                  ></path>
                </g>
              </svg>
            </button>
          </h1>
          <shop-details />
        </div>
      </b-sidebar>
    </div>
    <Map @opensidebar="toggleSidebar()"></Map>
    <buttons/>
    <shop-list @opensidebar="toggleSidebar()" />
    
  </div>
</template>

<script>
import Buttons from '../components/Buttons.vue';
import Map from '../components/Map.vue';
import ShopDetails from "../components/ShopDetails.vue";
import ShopList from "../components/ShopList.vue";

export default {
  components: {
    ShopList,
    ShopDetails,
    Map,
    Buttons,
  },
  data() {
    return {
      isSideBarOpen: false,
    };
  },
  methods: {
    toggleSidebar() {
      this.isSideBarOpen = !this.isSideBarOpen;
    },
  },
  computed: {},
};
</script>

<style scoped>

h1 {
  cursor: default;
}

</style>
