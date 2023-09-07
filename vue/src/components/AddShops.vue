<template>
  <div class="main-div">
    <form v-on:submit.prevent="addNewShop" id="coffeeShopForm">

      <div id="main-details">
      <label for="coffeeShopName">Coffee Shop Name: </label>
      <p><input type="text" v-model="newShop.shop" id="coffeeShopName" name="coffeeShopName" class="input-radius" required></p>

      <p class="instructions">Please provide an image that you would like associated with your shop.</p>
      <button id="image-button" @click.prevent="openUploadWidget()">Upload Image</button>
    
      <label for="coffeeShopWebLink"> Coffee Shop Website Link: </label>
      <p><input type="text" v-model="newShop.webLink" id="coffeeShopWebLink" name="coffeeShopWebLink"  class="input-radius" required></p>

<label for="coffeeShopPrice"> Coffee Shop Price Range: </label>
      <p><input type="text" v-model.number="newShop.price" id="coffeeShopPrice" name="coffeeShopPrice"  class="input-radius" required></p>
      <p class="instructions">Please provide a price range for your shop from 1 - 5. 1 is the lowest, 5 is the highest.</p>

      <label for="coffeeShopRating"> Coffee Shop Rating: </label>
      <p><input type="text" v-model.number="newShop.rating" id="coffeeShopRating" name="coffeeShopRating"  class="input-radius" required></p>
      <p class="instructions">Please provide your shop's rating based on Google Reviews to the nearest whole number.</p>
</div>

<div id="address">
      <label for="coffeeShopAddress"> Address: </label>
      <p><input type="text" v-model="newShop.address" id="coffeeShopAddress" name="coffeeShopAddress"  class="input-radius" required></p>

      <p class="instructions">You can enter your latitude and longitude below to have your shop show up on our map. <br>
                              You can use the following site to convert your address: <a href="https://www.latlong.net/convert-address-to-lat-long.html" target="_blank">latlong.net</a>
      </p>
      <label for="latitude"> Latitude: </label>
      <p><input type="text" v-model.number="newShop.latitude" id="latitude" name="latitude"  class="input-radius" required></p>

      <label for="longitude"> Longitude: </label>
      <p><input type="text"  v-model.number="newShop.longitude" id="longitude" name="longitude"  class="input-radius" required></p>
</div>
      
<!-- <section class="bottom-section"> -->
<div id="full-highlights">
      <p class="coffeeShopHighlights"><label for="coffeeShopHighlights" class="coffeeShopHighlights"> Coffee Shop Highlights: </label></p>
<div class="highlightBox">
      <p class="checkboxLabel margin"><input type="checkbox" v-model="newHighlights" name="food" id="food" value="food" class="checkbox">&nbsp;&nbsp;&nbsp;&nbsp;Food</p>
      <p class="checkboxLabel margin"><input type="checkbox" v-model="newHighlights" name="desserts" id="desserts" value="dessert" class="checkbox">&nbsp;&nbsp;&nbsp;&nbsp;Desserts</p>
      <p class="checkboxLabel margin"><input type="checkbox" v-model="newHighlights" name="smoothies" id="smoothies" value="smoothies" class="checkbox">&nbsp;&nbsp;&nbsp;&nbsp;Smoothies</p>
      <p class="checkboxLabel margin"><input type="checkbox" v-model="newHighlights" name="grounds" id="grounds" value="bean" class="checkbox">&nbsp;&nbsp;&nbsp;&nbsp;Beans and/or grounds</p>
      <p class="checkboxLabel margin"><input type="checkbox" v-model="newHighlights" name="alcohol" id="alcohol" value="alcohol" class="checkbox">&nbsp;&nbsp;&nbsp;&nbsp;Alcohol</p>
      <p class="checkboxLabel margin"><input type="checkbox" v-model="newHighlights" name="non-dairy" id="non-dairy" value="non-dairy" class="checkbox">&nbsp;&nbsp;&nbsp;&nbsp;Non-dairy alternatives</p>
      <p class="checkboxLabel margin"><input type="checkbox" v-model="newHighlights" name="outdoor seating" id="outdoor seating" value="outdoor seating" class="checkbox">&nbsp;&nbsp;&nbsp;&nbsp;Outdoor seating</p>
      <p class="checkboxLabel margin"><input type="checkbox" v-model="newHighlights" name="dog friendly" id="dog friendly" value="dog friendly" class="checkbox">&nbsp;&nbsp;&nbsp;&nbsp;Pet friendly<br></p>
</div>
</div>
<div id="shop-hours">
      <p>Enter Shop Hours:</p>
      <p class="instructions">Enter shop hours formatted as "9a-9p". If closed, "closed".</p>
      <div class="focused-hours">
        <div class="day">
      <label for="coffeeShopMonday" class="day-label">Monday: </label>
      <p class="margin"><input type="text" v-model="newShop.monday" id="coffeeShopHours" name="coffeeShopMonday" class="day-input" required></p>
        </div>
<div class="day">
      <label for="coffeeShopTuesday" class="day-label">Tuesday: </label>
      <p class="margin"><input type="text" v-model="newShop.tuesday" id="coffeeShopHours" name="coffeeShopTuesday" class="day-input" required></p>
</div>
<div class="day">
      <label for="coffeeShopWednesday" class="day-label">Wednesday: </label>
      <p class="margin"><input type="text" v-model="newShop.wednesday" id="coffeeShopHours" name="coffeeShopWednesday" class="day-input" required></p>
</div>
<div class="day">
      <label for="coffeeShopThursday" class="day-label">Thursday: </label>
      <p class="margin"><input type="text" v-model="newShop.thursday" id="coffeeShopHours" name="coffeeShopThursday" class="day-input" required></p>
</div>
<div class="day">
      <label for="coffeeShopFriday" class="day-label">Friday: </label>
      <p class="margin"><input type="text" v-model="newShop.friday" id="coffeeShopHours" name="coffeeShopFriday" class="day-input" required></p>
</div>
<div class="day">
      <label for="coffeeShopSaturday" class="day-label">Saturday: </label>
      <p class="margin"><input type="text" v-model="newShop.saturday" id="coffeeShopHours" name="coffeeShopSaturday" class="day-input" required></p>
</div>
<div class="day">
      <label for="coffeeShopSunday" class="day-label">Sunday: </label>
      <p><input type="text" v-model="newShop.sunday" id="coffeeShopHours" name="coffeeShopSunday" class="day-input" required></p>
      </div>
      </div>
</div>
<!-- </section> -->
<div id="submit-button">
      <button type="submit">Submit</button>
</div>

    </form>
  </div>
</template>

<script>
import ShopService from '../services/ShopService'
export default {
    name: "add-shops",
    components: {
       
    },
    data(){
      return {
        newHighlights: [],
        newShop: {
          shop: "",
          image: "",
          webLink: "",
          price: 0,
          rating: 0,
          highlights: "",
          menuLink: "",
          monday: "",
          tuesday: "",
          wednesday: "",
          thursday: "",
          friday: "",
          saturday: "",
          sunday: "",
          latitude: 0,
          longitude: 0,
          address: ""
        }
      }
    },
    methods: {
      openUploadWidget() {
      const widget = window.cloudinary.createUploadWidget(
        { cloud_name: "daogd81w1", upload_preset: "upload-jolt" },
        (error, result) => {
          if (!error && result && result.event === "success") {
            let url = String(result.info.secure_url);
            this.newShop.image = url;
          }
        }
      );
      widget.open()
    },
      addNewShop(){

        let output = "";
        for (let i = 0; i < this.newHighlights.length; i++) {
          if (this.newHighlights[i] != "") {
            output += this.newHighlights[i] + " ";
          } 
        }

        this.newShop.highlights = output;
      console.log(this.newShop.highlights);
      console.log("output=" + output);


        ShopService.addNewShop(this.newShop).then((response) => {
          if(response.status == 201) {
            this.$router.push('/shops');
          }
        })
        .catch(err => console.error(err));
      }
    }
}
</script>

<style scoped>

.main-div {
  background-color: #BFBCBA;
}
.instructions {
  font-size: 14px;
}

#coffeeShopForm {
  text-align: center;
  background-color: #FFFbf7;
  align-items: center;
  justify-content: space-between;
  width: 76%;
  margin-left: 12%;
  margin-right: 12%;
  border-top: 10px solid #BFBCBA;
  border-bottom: 10px solid #BFBCBA;
  box-shadow: 0 2px 4px 0 rgba(0, 0, 0, 0.2), 0 2.5rem 5rem 0 rgba(0, 0, 0, 0.1);
  display: grid;
  grid-template-columns: 1fr 1fr;
  flex-direction: column;
  grid-template-areas:
  "details details"
  "address address"
  "highlights hours"
  "submit submit"
  
}

.highlightBox {
  text-align: left;
  width: 100%;
  margin-left: 25%;
  margin-right: 0%;
}

.checkbox {
  justify-items: left;
  align-items: flex-start;
  text-align: left;
  margin-left: 10px;
}

.coffeeShopHighlights {
 width: 100%;
  justify-content: left;
  align-items: flex-start;
  text-align: left;
  margin-bottom: 10px;
  margin-left: 10%;
}
#main-details {
  grid-area: details;
  display: flex;
  flex-direction: column;
  margin-top: 10px;
}
#shop-hours {
  grid-area: hours;
  text-align: left;
  width: 76%;
  margin-left: 10%;
  margin-right: 5%;
}
#address {
  grid-area: address;
  display: flex;
  flex-direction: column;
}

#full-highlights {
  grid-area: highlights;
}
#submit-button {
  grid-area: submit;
  margin-bottom: 10px;
}

#image-button{
  width: fit-content;
  margin-left: 39%;
  margin-bottom: 10px;
}
.bottom-section {
  display: flex;
  width: 76%;
  margin-left: 10%;
  margin-right: 5%;
  column-gap: 5px;
}
.focused-hours {
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  
}
.day-input {
  max-width: 90px;
  border-radius: 4px;
}
.day {
  display: flex;
    align-items: center;
  justify-content: space-between;
  width: 81%;
  margin-left: 12%;
  margin-right: 0%;
}
.day > label {
  margin-right: 10%;
}
.margin {
  margin: 0;
}

.input-radius {
  border-radius: 4px;
}


@media screen and (max-width: 820px) {
  #coffeeShopForm {
  text-align: center;
  align-items: center;
  justify-content: space-between;
  width: 76%;
  margin-left: 12%;
  margin-right: 12%;
  display: flex;
  flex-direction: column;
  grid-template-areas:
  "details"
  "address"
  "hours"
  "highlights"
  "submit"
  }
  #shop-hours {
  grid-area: hours;
  text-align: left;
  width: 60%;
  margin-left: 5%;
  margin-right: 5%;
}
.highlightBox {
  text-align: left;
  width: 100%;
  margin-left: 10%;
  margin-right: 0%;
}
.coffeeShopHighlights {
 width: 100%;
  justify-content: left;
  align-items: flex-start;
  text-align: left;
  margin-bottom: 10px;
  margin-left: 0%;
}

@media screen and (max-width: 420px) {
  #coffeeShopForm {
  text-align: center;
  align-items: center;
  justify-content: space-between;
  width: 76%;
  margin-left: 12%;
  margin-right: 12%;
  display: flex;
  flex-direction: column;
  grid-template-areas:
  "details"
  "address"
  "hours"
  "highlights"
  "submit"
  }
  #shop-hours {
  grid-area: hours;
  text-align: left;
  width: 90%;
  margin-left: 5%;
  margin-right: 5%;
}
.highlightBox {
  text-align: left;
  width: 100%;
  margin-left: 10%;
  margin-right: 0%;
}
.coffeeShopHighlights {
 width: 100%;
  justify-content: left;
  align-items: flex-start;
  text-align: left;
  margin-bottom: 10px;
  margin-left: 0%;
}
}
}
</style>