<template>
  <el-menu class="navbar" mode="horizontal">
    <hamburger class="hamburger-container" :toggleClick="toggleSideBar" :isActive="sidebar.opened"></hamburger>
    <breadcrumb></breadcrumb>
    <div class="title">
      <h2>京东方(重庆)智造三车间</h2>
      </div>
    <div style="display: inline-block; position: absolute; top:0;right: 200px;">
      <!-- <el-tooltip class="item" effect="white" content="上一页" placement="top-start"> -->
        <el-button type="text" icon="el-icon-d-arrow-left" @click="goBack"></el-button>
      <!-- </el-tooltip> -->
      <!-- <el-tooltip class="item" effect="white" content="下一页" placement="top-start"> -->
        <el-button type="text" icon="el-icon-d-arrow-right" @click="goBefore"></el-button>
      <!-- </el-tooltip> -->
    </div>
    <el-dropdown class="avatar-container" trigger="click">
      <div class="avatar-wrapper">
        <span class="user-nickname">{{nickname}}</span>
        <el-badge :value="alarmCount" type="warning" style="margin-top:-70px;margin-right:10px;margin-left:-15px;height:20px;" v-if="alarmCount">
        </el-badge>
        <!--<img class="user-avatar" :src="avatar+'?imageView2/1/w/80/h/80'">-->
        <img class="user-avatar" :src="avatar">
        <i class="el-icon-caret-bottom"></i>
      </div>
      <el-dropdown-menu class="user-dropdown" slot="dropdown">
        <router-link class="inlineBlock" to="/">
          <el-dropdown-item>
            Home
          </el-dropdown-item>
        </router-link>
        <router-link class="inlineBlock" to="/info">
          <el-dropdown-item>
            User
          </el-dropdown-item>
        </router-link>
        <el-dropdown-item divided>
          <span @click="logout" style="display:block;">LogOut</span>
        </el-dropdown-item>
      </el-dropdown-menu>
    </el-dropdown>
  </el-menu>
</template>

<script>
import { mapGetters } from 'vuex'
import Breadcrumb from '@/components/Breadcrumb'
import Hamburger from '@/components/Hamburger'

export default {
  components: {
    Breadcrumb,
    Hamburger
  },
  computed: {
    ...mapGetters([
      'sidebar',
      'avatar',
      'nickname',
      'alarmCount'
    ])
  },
  methods: {
    toggleSideBar () {
      this.$store.dispatch('ToggleSideBar')
    },
    logout () {
      this.$store.dispatch('LogOut').then(() => {
        location.reload() // 为了重新实例化vue-router对象 避免bug
      })
    },
    goBack () {
      window.history.length > 1
        ? this.$router.go(-1)
        : this.$router.push('/')
    },
    goBefore () {
      window.history.length > 1
        ? this.$router.go(1)
        : this.$router.push('/')
    }
  }
}
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
.navbar {
  position: fixed;
  top: 0;
  left: 0;
  right: 0;
  z-index: 1010;
  height: 50px;
  line-height: 50px;
  border-radius: 0px !important;
  .hamburger-container {
    line-height: 58px;
    height: 50px;
    float: left;
    padding: 0 10px;
  }
  .screenfull {
    position: absolute;
    right: 90px;
    top: 16px;
    color: red;
  }
  .avatar-container {
    size: 'normal';
    height: 50px;
    display: inline-block;
    position: absolute;
    right: 20px;
    .avatar-wrapper {
      cursor: pointer;
      margin-top: 5px;
      position: relative;
      height: 40px;
      .user-avatar {
        width: 40px;
        height: 40px;
        border-radius: 10px;
      }
      .user-nickname {
        padding: 10px 0;
        position: relative;
        top: -15px;
        margin-right: 10px;;
      }
      .el-icon-caret-bottom {
        position: relative;
        right: -20px;
        top: -15px;
        font-size: 12px;
        display: none;
      }
    }
  }
}
.el-menu--horizontal {
  border-right: none;
  border-bottom: solid 0px #e6e6e6;
}
.title {
  display: inline-block;
  margin: 0;
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
}
</style>
