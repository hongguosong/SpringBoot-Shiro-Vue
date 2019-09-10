<template>
  <div>
    <div>{{test}}</div>
    <el-button type="primary" size="mini" @click="att">calculate</el-button>
  </div>
</template>
<script>
export default {
  name: 'async',
  data () {
    return {
      test: 0
    }
  },
  methods: {
    async timeOut (flag) {
      if (flag) {
        return 'hello world.'
      } else {
        throw Error('my god, failure.')
      }
    },
    att: function () {
      console.log(this.timeOut(true).then(res => {
        console.log(res)
      }))
      console.log(this.timeOut(false).catch(err => {
        console.log(err.message)
      }))
      this.testresult()
    },
    double2s: function (num) {
      return new Promise((resolve, reject) => {
        setTimeout(() => {
          resolve(2 * num)
        }, 2000)
      })
    },
    async testresult () {
      let first = await this.double2s(30)
      let second = await this.double2s(10)
      let third = await this.double2s(2)

      this.test = first + second + third
    }
  }
}
</script>
<style scoped>

</style>
