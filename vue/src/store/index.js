import Vue from 'vue'
import Vuex from 'vuex'
import app from './modules/app'
import user from './modules/user'
import permission from './modules/permission'
import getters from './getters'
import counter from './modules/counter'

Vue.use(Vuex)

const state = {
  count: 997
}


const store = new Vuex.Store({
  modules: {
    app,
    user,
    permission,
    counter
  },
  getters,
  state
})

export default store
