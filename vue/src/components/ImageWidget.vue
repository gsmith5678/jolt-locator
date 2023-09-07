<!-- <script setup>
const widget = window.cloudinary.createUploadWidget(
  { cloud_name: "daogd81w1", upload_preset: "upload-jolt" },
  (error, result) => {
    if (!error && result && result.event === "success") {
      console.log("Done uploading.....", result.info);
      let url = String(result.info.secure_url);
      console.log(url);
      this.$store.commit("SET_IMAGE_URL", url);
    }
  }
);

function openUploadWidget() {
  widget.open();
}
</script> -->
<template>
  <div>
    <button @click.prevent="openUploadWidget()">Upload Image</button>
  </div>
</template>
<script>
export default {
  date() {},
  methods: {
    openUploadWidget() {
      const widget = window.cloudinary.createUploadWidget(
        { cloud_name: "daogd81w1", upload_preset: "upload-jolt" },
        (error, result) => {
          if (!error && result && result.event === "success") {
            console.log("Done uploading.....", result.info);
            let url = String(result.info.secure_url);
            console.log(url);
            this.$store.commit("SET_IMAGE_URL", url);
          }
        }
      );
      widget.open()
    },
  },
};
</script>
<style>
</style>