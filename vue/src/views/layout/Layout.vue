<template>
  <div class="app-wrapper" :class="{hideSidebar:!sidebar.opened}">
    <!--<navbar class="nav-container" :style="{backgroundImage: mountain}"></navbar>-->
    <navbar class="nav-container"></navbar>
    <div class="main-container">
      <transition enter-active-class="animated zoomIn" leave-active-class="animated zoomOut">
        <sidebar class="sidebar-container" v-show="sidebar.opened"></sidebar>
      </transition>
      <app-main></app-main>
      <footbar class="foot-container"></footbar>
    </div>
  </div>
</template>

<script>
import { Navbar, Sidebar, AppMain, Footbar } from '@/views/layout/components'
import mountain from '@/images/mountain.jpg'
export default {
  name: 'layout',
  data () {
    return {
      mountain: 'url(' + mountain + ')'
    }
  },
  components: {
    Navbar,
    Sidebar,
    AppMain,
    Footbar
  },
  computed: {
    sidebar () {
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
  /*background: linear-gradient(left, #EED5D2, #C7C7E2);*/
  background: linear-gradient(left, #C7C7E2, white);
  background: -webkit-gradient(linear, left top, right top, from(#C7C7E2), to(white));
}
</style>
