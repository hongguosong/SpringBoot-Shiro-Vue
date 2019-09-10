import Vue from 'vue'
import Vuex from 'vuex'
import app from './modules/app'
import user from './modules/user'
import permission from './modules/permission'
import getters from './getters'
import counter from './modules/counter'
import todo from './modules/todo'

Vue.use(Vuex)

const state = {
  count: 997,
  alarmDialogVisible: false,
  alarmData: []
}

const mutations = {
  SETALARMDIALOGVISIBLE: (state, visible) => {
    console.log(visible)
    state.alarmDialogVisible = visible
  },
  SETALARMDATA: (state, data) => {
    var i = state.alarmData.length
    while (i--) {
      if (state.alarmData[i].id === data.id) {
        state.alarmData.splice(i, 1)
      }
    }
    for (var j = 0; j < data.list.length; j++) {
      state.alarmData.push(data.list[j])
    }
  }
}

const store = new Vuex.Store({
  modules: {
    app,
    user,
    permission,
    counter,
    todo
  },
  getters,
  mutations,
  state
})

export default store
