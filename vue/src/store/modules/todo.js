import axios from 'axios'
import { Message } from 'element-ui'

const state = {
  todos: [
    { text: 'xx', done: false, date: '2018-06-09 12:12:12' },
    { text: 'yy', done: false, date: '2018-06-19 12:12:12' }
  ]
}

const mutations = {
  addTodo (state, { name, text, done, date }) {
    state.todos.push({
      name: name,
      text: text,
      done: done,
      date: date
    })
  },

  deleteTodo (state, { todo }) {
    state.todos.splice(state.todos.indexOf(todo), 1)
  },

  toggleTodo (state, { todo }) {
    todo.done = !todo.done
  },

  editTodo (state, { todo, value }) {
    todo.text = value
  },

  toggleAll (state, { done }) {
    state.todos.forEach((todo) => {
      todo.done = done
    })
  },

  clearCompleted (state) {
    state.todos = state.todos.filter(todo => !todo.done)
  }
}

const actions = {
  getTodosAsyc (context) {
    var name = context.rootState.user.username
    axios({
      method: 'get',
      url: '/api/todo/list?name=' + name,
      contentType: 'application/json; charset=utf-8'
    }).then(function (response) {
      state.todos = []
      if (response.data && response.data.length > 0) {
        for (var i = 0; i < response.data.length; i++) {
          context.commit('addTodo', {
            name: response.data[i].name,
            text: response.data[i].text,
            done: response.data[i].done,
            date: response.data[i].date })
        }
      }
    }).catch(function (response) {

    })
  },
  addTodoAsyc (context, { name, text, done, date }) {
    axios({
      method: 'post',
      url: '/api/todo/add',
      contentType: 'application/json; charset=utf-8',
      data: {
        'name': name,
        'text': text,
        'done': done,
        'date': date
      }
    }).then(function (response) {
      if (response.data) {
        context.commit('addTodo', { name, text, done, date })
      }
    }).catch(function (response) {

    })
  },
  toggleTodoAsyc (context, { todo }) {
    context.commit('toggleTodo', { todo })
    axios({
      method: 'post',
      url: '/api/todo/updateDone',
      contentType: 'application/json; charset=utf-8',
      data: {
        'name': todo.name,
        'text': todo.text,
        'done': todo.done,
        'date': todo.date
      }
    }).then(function (response) {
      if (response.data) {
        // Message.success('toggle成功')
      } else {
        Message.error('togglr失败')
      }
    }).catch(function (response) {
      Message.error('togglr失败')
    })
  },
  toggleAllAsyc (context, { done }) {
    axios({
      method: 'post',
      url: '/api/todo/updateAll?done=' + done + '&name=' + context.rootState.user.username,
      contentType: 'application/json; charset=utf-8'
    }).then(function (response) {
      if (response.data) {
        context.commit('toggleAll', { done })
        // Message.success('toggleAll成功')
      } else {
        Message.error('toggleAll失败')
      }
    }).catch(function (response) {
      Message.error('toggleAll失败')
    })
  },
  deleteTodoAsyc (context, { todo }) {
    axios({
      method: 'post',
      url: '/api/todo/delete',
      contentType: 'application/json; charset=utf-8',
      data: {
        'name': todo.name,
        'text': todo.text,
        'done': todo.done,
        'date': todo.date
      }
    }).then(function (response) {
      if (response.data) {
        context.commit('deleteTodo', { todo })
        Message.success('删除成功')
      } else {
        Message.error('删除失败')
      }
    }).catch(function (response) {
      Message.error('删除失败')
    })
  },
  editTodoAsyc (context, { todo, value }) {
    context.commit('editTodo', { todo, value })
    axios({
      method: 'post',
      url: '/api/todo/updateText',
      contentType: 'application/json; charset=utf-8',
      data: {
        'name': todo.name,
        'text': todo.text,
        'done': todo.done,
        'date': todo.date
      }
    }).then(function (response) {
      if (response.data) {
        Message.success('修改成功')
      } else {
        Message.error('修改失败')
      }
    }).catch(function (response) {
      Message.error('修改失败 ', response)
    })
  },
  clearCompletedAsyc (context) {
    axios({
      method: 'post',
      url: '/api/todo/deleteCompleted?name=' + context.rootState.user.username,
      contentType: 'application/json; charset=utf-8'
    }).then(function (response) {
      if (response.data) {
        context.commit('clearCompleted')
      } else {

      }
    }).catch(function (response) {

    })
  }
}

export default {
  state,
  mutations,
  actions
}
