<template>
  <div>
    <el-button @click="count = 2">this.$store.state.counter.count: {{count}}</el-button>
    <div>mapGetters: {{COUNT}}</div>
    <div>mapMutations: <el-button @click="DECREMENT">{{COUNT}}</el-button></div>
    <div>mapActions: <el-button @click="log">{{COUNT}}</el-button></div>
    <div>异步调用: <el-button @click="y1">加减</el-button></div>
  </div>
</template>

<script>
import { mapGetters, mapMutations, mapActions } from 'vuex'
export default {
  name: 'vuex',
  data () {
    return {

    }
  },
  computed: {
    count: {
      get: function () {
        return this.$store.state.counter.count
      },
      set: function (newValue) {
        this.$store.dispatch('incrementNum', newValue)
      }
    },
    ...mapGetters([
      'COUNT'
    ])
  },
  methods: {
    ...mapMutations({
      add: 'INCREMENT'
    }),
    ...mapMutations([
      'DECREMENT',
      'NUM',
      'PAYLOAD'
    ]),
    ...mapActions([
      'incrementNum',
      'payLoad',
      'ad',
      'dd',
      'bw',
      'y1'
    ]),
    log: function () {
      console.log(this.ad())
      this.ad().then(this.bw())
      console.log('我在后面')
    }
  }
}
</script>

<style scoped>

</style>
