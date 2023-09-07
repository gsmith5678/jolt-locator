<template>
<div class="button-holder">
  <div class="button-component">
    <button @click="$store.commit('SET_DIRECTIONS')" id="get-directions">Get Directions</button>
    <button @click="$store.commit('CLEAR_DIRECTIONS')" id="clear-directions">Clear Directions</button>
    <select name="filterDropdown" @change="onChange($event)" id="form-select" class="form-select form-control">
        <option value="">--Filter Shops By Selection--</option>
        <option value="filter-by-favorites">Filter By Favorites</option> 
        <option value="filter-by-rating">Filter By Rating</option> 
        <option value="filter-by-distance">Filter By Distance</option>
        <option value="filter-by-visited">Filter By Visited</option> 
      </select>
  </div>
</div>
</template>

<script>
export default {
methods: {
    onChange(e){
      let selected = e.target.value
      console.log(selected)
      this.$store.commit("SET_DROPDOWN_SELECTION", selected)
    },
}
}
</script>

<style scoped>
#form-select{
  width: min-content;
  height: max-content;
  font: inherit;
  color: black;
  background-color: white;
  border: 0.2rem #999 solid;
  border-radius: 5px;
  box-shadow: 0 1.5px #666;
  padding: 5px 15px 5px 15px;
  line-height: normal;
}
.button-component {
  display: flex;
  justify-content:center;
  column-gap: 2em;
  margin-top: 20px;
  padding-bottom: 0px;
}

@media screen and (max-width: 820px) {
  #form-select{
  width: min-content;
  height: max-content;
  font: inherit;
  color: black;
  background-color: white;
  border: 0.2rem #999 solid;
  border-radius: 5px;
  box-shadow: 0 1.5px #666;
  padding: 5px 15px 5px 15px;
  line-height: normal;
}
.button-component {
  display: flex;
  flex-direction: column;
  justify-content: center;
  width: min-content;
  height: max-content;
  column-gap: 2em;
  margin-top: 20px;
  padding-bottom: 0px;
}

.button-holder {
  display: flex;
  justify-content: center;
}

  @media screen and (max-width: 420px) {
  #form-select{
  width: min-content;
  height: max-content;
  font: inherit;
  color: black;
  background-color: white;
  border: 0.2rem #999 solid;
  border-radius: 5px;
  box-shadow: 0 1.5px #666;
  padding: 5px 15px 5px 15px;
  line-height: normal;
}
.button-component {
  display: flex;
  flex-direction: column;
  justify-content: center;
  width: min-content;
  height: max-content;
  column-gap: 2em;
  margin-top: 20px;
  padding-bottom: 0px;
}
  }

.button-holder {
  display: flex;
  justify-content: center;
}

}
</style>