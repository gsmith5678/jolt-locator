import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'

Vue.use(Vuex)

/*
 * The authorization header is set for axios when you login but what happens when you come back or
 * the page is refreshed. When that happens you need to check for the token in local storage and if it
 * exists you should set the header so that it will be attached to each request
 */
const currentToken = localStorage.getItem('token')
const currentUser = JSON.parse(localStorage.getItem('user'));

if(currentToken != null) {
  axios.defaults.headers.common['Authorization'] = `Bearer ${currentToken}`;
}

export default new Vuex.Store({
  state: {
    favoritesList: [],
    visitedList: [],
    dropdownSelection: '',
    isGetDirections: false,
    isClearDirections: false,
    activeShop: [],
    shops: [],
    token: currentToken || '',
    user: currentUser || {},
    coordinates: {
      lat: 0,
      lng: 0,
    },
  },
  mutations: {
    SET_AUTH_TOKEN(state, token) {
      state.token = token;
      localStorage.setItem('token', token);
      axios.defaults.headers.common['Authorization'] = `Bearer ${token}`
    },
    SET_USER(state, user) {
      state.user = user;
      localStorage.setItem('user',JSON.stringify(user));
    },
    LOGOUT(state) {
      localStorage.removeItem('token');
      localStorage.removeItem('user');
      state.token = '';
      state.user = {};
      axios.defaults.headers.common = {};
    },
    SET_SHOPS(state, shops) {
      state.shops = shops;
    },
    SET_ACTIVE_SHOP(state, shop, ) {
      state.activeShop = shop;
    },
    SET_COORDINATES(state, coordinates){
      state.coordinates = coordinates
    },
    SET_DIRECTIONS(state){
      state.isGetDirections = !state.isGetDirections;
    },
    CLEAR_DIRECTIONS(state){
      state.isClearDirections = !state.isClearDirections
    },
    SET_DROPDOWN_SELECTION(state, selection){
      state.dropdownSelection = selection;
      console.log("in store mutation. Val of dropdown = " + state.dropdownSelection)
    },
    SET_FAVORITES_LIST(state, favoritesList){
      state.favoritesList = favoritesList;
    },
    SET_VISITED_LIST(state, visitedList){
      state.visitedList = visitedList;
    },
 }
})
