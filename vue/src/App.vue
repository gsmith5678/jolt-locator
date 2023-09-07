<template>
  <div id="app">
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css?family=Tangerine">
         <link rel="stylesheet"
          href="https://fonts.googleapis.com/css?family=Playfair+Display"> 
<div class="logo-holder">
    <img src="./assets/jolt_logo.png" alt="" id="logo">
    </div>
    <div id="nav">
      
    
      <router-link class="link" v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link class="link" v-bind:to="{ name: 'shops' }">Shops</router-link>&nbsp;|&nbsp;
      <router-link class="link" v-if="isOwner" v-bind:to="{ name: 'add-shops' }">Add Your Coffee Shop&nbsp;|&nbsp;</router-link>
      <router-link class="link" v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
      <router-link class="link" v-bind:to="{ name: 'login' }" v-if="$store.state.token == ''">Login</router-link>
      <router-link class="link" v-if="isAdmin" v-bind:to="{ name: 'admin' }">&nbsp;|&nbsp;Admin</router-link>


    <div class="spacer"></div>
    </div>
    <router-view />

  </div>
</template>

<script>

export default {
  
  computed: {
    isOwner() {

      if(!this.$store.state.user.authorities) {
        return false;
      }
      let ownerRole = false;

      this.$store.state.user.authorities.forEach(role => {
        if(role.name == 'ROLE_OWNER') {
          ownerRole = true;
        }
      })
      return ownerRole;
    },
     isAdmin() {

      if(!this.$store.state.user.authorities) {
        return false;
      }
      let adminRole = false;

      this.$store.state.user.authorities.forEach(role => {
        if(role.name == 'ROLE_ADMIN') {
          adminRole = true;
        }
      })
      return adminRole;
    }  
  }
  
}
</script>


<style>
/* Global styles */
/* These styles are applied to the App element and it's children.
These will overwrite defaults set in 'assets/reset.css' (which are imported into 'src/main.js').
There are generic button themes available, though mostly just useful for reference.*/

.logo-holder {
  display: flex;
}

#logo {
  width: 10%;
  text-align: left;
}
.btn {
  padding: 0.8rem 1rem 0.7rem;
  cursor: pointer;
  text-transform: capitalize;
}
.btn__danger {
  color: #fff;
  background-color: #ca3c3c;
  border-color: #bd2130;
}
.btn__filter {
  border-color: lightgrey;
}
.btn__danger:focus {
  outline-color: #c82333;
}
.btn__primary {
  color: #fff;
  background-color: #000;
}
.btn-group {
  display: flex;
  justify-content: space-between;
}
.btn-group > * {
  flex: 1 1 auto;
}
.btn-group > * + * {
  margin-left: 0.8rem;
}
.label-wrapper {
  margin: 0;
  flex: 0 0 100%;
  text-align: center;
}
[class*="__lg"] {
  display: inline-block;
  width: 100%;
  font-size: 1.9rem;
}
[class*="__lg"]:not(:last-child) {
  margin-bottom: 1rem;
}
@media screen and (min-width: 620px) {
  [class*="__lg"] {
    font-size: 2.4rem;
  }
}
.visually-hidden {
  position: absolute;
  height: 1px;
  width: 1px;
  overflow: hidden;
  clip: rect(1px 1px 1px 1px);
  clip: rect(1px, 1px, 1px, 1px);
  clip-path: rect(1px, 1px, 1px, 1px);
  white-space: nowrap;
}
[class*="stack"] > * {
  margin-top: 0;
  margin-bottom: 0;
}
.stack-small > * + * {
  margin-top: 1.25rem;
}
.stack-large > * + * {
  margin-top: 2.5rem;
}
@media screen and (min-width: 550px) {
  .stack-small > * + * {
    margin-top: 1.4rem;
  }
  .stack-large > * + * {
    margin-top: 2.8rem;
  }
}
/* End global styles */
#app {
  background: #fffbf7;
  text-align: center;
  color: #212529;
  margin-top: 60px;
  margin: 2rem 0 4rem 0;
  padding: 1rem;
  padding-top: 0;
  position: relative;
  box-shadow: 0 2px 4px 0 rgba(0, 0, 0, 0.2), 0 2.5rem 5rem 0 rgba(0, 0, 0, 0.1);
  /* -webkit-font-smoothing: antialiased; */
  /* -moz-osx-font-smoothing: grayscale; */
  
}
@media screen and (min-width: 550px) {
  #app {
    padding: 4rem;
  }
}
#app > * {
  margin-left: auto;
  margin-right: auto;
}
#app > form {
  max-width: 100%;
}
#app h1 {
  display: block;
  min-width: 100%;
  width: 100%;
  text-align: center;
  margin: 0;
  margin-bottom: 1rem;
}

#nav {
  border-bottom: 3px solid;
  margin-bottom: 15px;
  margin-top: -65px;
  text-transform: uppercase;
  font-weight: 700;
}

.spacer {
  padding-bottom: 10px;
  margin-bottom: 10px;
}

.fancy-text {
  font-family: 'Tangerine';
  font-size: 48px;
  font-weight: bold;
}

@media screen and (max-width: 680px) {
  #nav {
    margin-top: 0px;
  }

  #logo {
    display: none;
  }
  
}

</style>