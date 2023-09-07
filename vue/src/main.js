import Vue from 'vue'
import App from './App.vue'
import router from './router/index'
import store from './store/index'
import axios from 'axios'
import { BootstrapVue, BootstrapVueIcons } from 'bootstrap-vue'
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'
import './assets/reset.css'
import * as VueGoogleMaps from 'vue2-google-maps'
import VueGeolocation from 'vue-browser-geolocation'
/* import PrettyCheckbox from 'pretty-checkbox-vue';

Vue.use(PrettyCheckbox); */


Vue.use(VueGeolocation)
//npm install vue-browser-geolocation
Vue.use(VueGoogleMaps, {
  load:{
    key: 'AIzaSyCVy4x5rS6lAKhTiYhLxX-q0hlpkLQEJUs'
  },
  installComponents: true
})
//npm install --save-dev vue2-google-maps

Vue.use(BootstrapVue)
Vue.use(BootstrapVueIcons)

Vue.config.productionTip = false

axios.defaults.baseURL = process.env.VUE_APP_REMOTE_API;

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
