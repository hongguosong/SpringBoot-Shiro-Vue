<template>
  <section class="app-main">
    <transition name="fade" mode="out-in" enter-active-class="animated slideInLeft">
      <!-- <router-view :key="key"></router-view> -->
      <router-view></router-view>
    </transition>
  </section>
</template>

<script>
export default {
  name: 'AppMain',
  data () {
    return {
    }
  },
  computed: {
    // key() {
    //   return this.$route.name !== undefined ? this.$route.name + +new Date() : this.$route + +new Date()
    // }
  },
  methods: {
  }
}
</script>

<style>
  .app-main {
    padding: 20px;
  }
</style>
