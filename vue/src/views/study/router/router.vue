<template>
  <div class="animated rollIn">
    <h1>Hello App</h1>
    <router-link :to="path">Go to Here</router-link>
    <div>$route.params.id: {{$route.params.id}}</div>
    <div>props id: {{id}}</div>
    <el-button @click="add">COUNT++ {{COUNT}}</el-button>
    <div>{{pa}}</div>

    <div>
      <el-button @click="go">go to button</el-button>
      <br/>
      <router-link :to="{ name: 'router', params: { id: this.COUNT }}">{{a}}</router-link>
      <br/>
      <router-link :to="{ path: `/studyVue/router/${this.COUNT}` }">{{b}}</router-link>
    </div>

    <div>
      测试路由跳转动画
      <router-link :to="{ name: 'vuex'}">vuex</router-link>
      <br/>
      <router-link :to="{ path: `/studyVue/router/${this.COUNT}` }">router</router-link>
    </div>
    <transition name="bounce">
      <router-view></router-view>
    </transition>
  </div>
</template>

<script>
import { mapGetters, mapMutations } from 'vuex'
export default {
  name: 'router',
  props: ['id'],
  data () {
    return {
      // id: 10,
      a: '<router-link :to="{ name: \'router\', params: { id: this.COUNT }}">{{a}}</router-link>', // eslint-disable-line
      b: '<router-link :to="{ path: `/studyVue/router/${this.COUNT}` }">{{b}}</router-link>' // eslint-disable-line
    }
  },
  computed: {
    pa: function () {
      return this.$route.params
    },
    path: function () {
      return '/studyVue/router/' + this.id
    },
    ...mapGetters([
      'COUNT'
    ])
  },
  methods: {
    // add: function () {
    //   //this.id++
    // },
    ...mapMutations({
      add: 'INCREMENT'
    }),
    go: function () {
      this.$router.push({ name: 'router', params: { id: this.COUNT } })

      // 或者
      // this.$router.push({ path: `/studyVue/router/${this.id}` })
    }
  },
  // watch: {
  //   '$route' (to, from) {
  //     console.log(to)
  //     console.log(from)
  //   }
  // },
  beforeRouteUpdate (to, from, next) {
    // console.log(to)
    // console.log(from)
    next()
  },
  beforeRouteEnter (to, from, next) {
    next(vm => {
      // 通过 `vm` 访问组件实例
      // to.params.id = 19
      vm.add()
    })
  },
  beforeRouteLeave (to, form, next) {
    // const answer = window.confirm('Do you really want to leave? you have unsaved changes!')
    // if (answer) {
    //   next()
    // } else {
    //   next(false)
    // }
    this.$confirm('Do you really want to leave? you have unsaved changes!', '提示', {
      confirmButtonText: '确定',
      cancelButtonText: '取消',
      type: 'warning'
    }).then(() => {
      this.$message({
        type: 'success',
        message: '离开成功!'
      })
      next()
    }).catch(() => {
      this.$message({
        type: 'info',
        message: '已取消离开'
      })
      next(false)
    })
  }
}
</script>

<style scoped>
  .bounce-enter-active {
    animation: bounce-in .5s;
  }
  .bounce-leave-active {
    animation: bounce-in .5s reverse;
  }
  @keyframes bounce-in {
    0% {
      transform: scale(0);
    }
    50% {
      transform: scale(1.5);
    }
    100% {
      transform: scale(1);
    }
  }

  /*.transitionRouter-enter-active,*/
  /*.transitionRouter-leave-active {*/
    /*transition: all 0.7s;*/
  /*}*/

  /*.transitionRouter-enter,*/
  /*.transitionRouter-leave{*/
    /*transform: translate3d(100%, 0, 0);*/
  /*}*/
</style>
