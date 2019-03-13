const counter = {
  state: {
    count: 0,
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
    incrementNum: ({commit, state}, num) => {
      commit('NUM', num)
    },
    payLoad: ({commit, state}, pay) => {
      commit('PAYLOAD', pay)
    },
    async ad (context) {
      context.commit('INCREMENT')
    },
    async dd (context) {
      context.commit('DECREMENT')
    },
    async bw (context) {
      await context.dispatch('ad')
    }
  }
}

export default counter
