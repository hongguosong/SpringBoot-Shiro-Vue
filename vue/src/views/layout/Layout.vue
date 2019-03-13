<template>
  <div class="app-wrapper" :class="{hideSidebar:!sidebar.opened}">
    <navbar class="nav-container" :style="{backgroundImage: mountain}"></navbar>
    <div class="main-container">
      <sidebar class="sidebar-container" v-show="sidebar.opened"></sidebar>
      <app-main></app-main>
    </div>
  </div>
</template>

<script>
import { Navbar, Sidebar, AppMain } from '@/views/layout/components'
import mountain from '@/images/mountain.jpg'

export default {
  name: 'layout',
  data () {
    return {
      mountain: 'url('+ mountain + ')'
    }
  },
  components: {
    Navbar,
    Sidebar,
    AppMain
  },
  computed: {
    sidebar() {
      return this.$store.state.app.sidebar
    }
  }
}
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
@import "src/styles/mixin.scss";
.app-wrapper {
  @include clearfix;
  position: relative;
  height: 100%;
  width: 100%;
}
.nav-container {
  // background-color: #EED5D2;
}
</style>
