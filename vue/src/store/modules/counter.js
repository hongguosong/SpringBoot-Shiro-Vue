const counter = {
  state: {
    count: 0
  },
  getters: {
    COUNT: state => {
      return state.count
    }
  },
  mutations: {
    INCREMENT: state => {
      state.count++
    },
    DECREMENT: state => {
      state.count--
    },
    NUM: (state, num) => {
      state.count += num
    },
    PAYLOAD: (state, payLoad) => {
      state.count += payLoad.amount
    }
  },
  actions: {
    incrementNum: ({ commit, state }, num) => {
      commit('NUM', num)
    },
    payLoad: ({ commit, state }, pay) => {
      commit('PAYLOAD', pay)
    },
    async ad (context) {
      return new Promise((resolve, reject) => {
        setTimeout(() => {
          context.commit('INCREMENT')
          resolve(context.getters.COUNT)
        }, 2000)
      })
    },
    async dd (context) {
      return new Promise((resolve, reject) => {
        setTimeout(() => {
          context.commit('DECREMENT')
          resolve(context.getters.COUNT)
        }, 3000)
      })
    },
    async bw (context) {
      await context.dispatch('ad')
    },
    async y1 (context) {
      let a = await context.dispatch('ad')
      if (a > 10) {
        await context.dispatch('dd')
      } else {
        await context.dispatch('ad')
      }
    }
  }
}

export default counter
