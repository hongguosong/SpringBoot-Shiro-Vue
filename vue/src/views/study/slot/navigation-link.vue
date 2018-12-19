<template>
    <a v-bind:href="url">
      <slot></slot>
    </a>
</template>

<script>
export default {
  name: "navigation-link",
  data () {
    return {
      url: ''
    }
  }

}
</script>

<style scoped>

</style>
