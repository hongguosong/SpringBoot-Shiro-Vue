<template>
  <section id="todoList" class="todoapp">
    <header class="header">
      <div class="header-title">todos</div>
      <div class="header-body">
        <input class="toggle-all" id="toggle-all"
               type="checkbox"
               :checked="allChecked"
               @change="toggleAllAsyc({ done: !allChecked })">
        <label for="toggle-all">^</label>
        <input class="new-todo"
               autofocus
               autocomplete="off"
               placeholder="What needs to be done?"
               @keyup.enter="addTodo"/>
      </div>
    </header>

    <!-- main section -->
    <section class="main" v-show="todos.length">
      <ul class="todo-list">
        <todo v-for="(todo, index) in filteredTodos" :key="index" :todo="todo"></todo>
      </ul>
    </section>
    <!-- footer -->
    <footer class="footer" v-show="todos.length">
      <el-row>
        <el-col :span="6">
          <span class="todo-count">
            <strong>{{ remaining }}</strong>
            {{ remaining | pluralize('item') }} left
          </span>
        </el-col>
        <el-col :span="12">
          <ul class="filters">
            <li v-for="(val, key) in filters" :key="key">
              <a
                :href="'#/' + key"
                :class="{ selected: visibility === key }"
                @click="visibility = key">{{ key | capitalize }}</a>
            </li>
          </ul>
        </el-col>
        <el-col :span="6">
          <button class="clear-completed"
                  v-show="todos.length > remaining"
                  @click="clearCompletedAsyc">
            Clear completed
          </button>
        </el-col>
      </el-row>
    </footer>

    <div>
      <el-button @click="getWe">
        MockTest
      </el-button>
      <div>{{mockData}}</div>
    </div>

  </section>
</template>

<script>
import { mapMutations, mapActions } from 'vuex'
import Todo from './todoItem.vue'
// import moment from 'moment'
import axios from 'axios'

const filtersMe = {
  all: todos => todos,
  active: todos => todos.filter(todo => !todo.done),
  completed: todos => todos.filter(todo => todo.done)
}

export default {
  name: 'todo-list',
  components: { Todo },
  data () {
    return {
      visibility: 'all',
      filters: filtersMe,
      mockData: ''
    }
  },
  computed: {
    todos () {
      return this.$store.state.todo.todos
    },
    allChecked () {
      return this.todos.every(todo => todo.done)
    },
    filteredTodos () {
      return filtersMe[this.visibility](this.todos)
    },
    remaining () {
      return this.todos.filter(todo => !todo.done).length
    }
    // pluralize: (n, w) => n === 1 ? w : (w + 's'),
    // capitalize: s => s.charAt(0).toUpperCase() + s.slice(1)
  },
  methods: {
    ...mapMutations([
      'toggleAll',
      'clearCompleted'
    ]),
    ...mapActions([
      'getTodosAsyc',
      'addTodoAsyc',
      'toggleAllAsyc',
      'clearCompletedAsyc'
    ]),
    addTodo (e) {
      var text = e.target.value
      if (text.trim()) {
        var name = this.$store.state.user.username
        // var date = moment(new Date()).format('YYYY-MM-DD HH:mm:ss')
        var date = this.moment(new Date())
        var done = false
        this.addTodoAsyc({ name, text, done, date })
      }
      e.target.value = ''
    },
    getWe () {
      var that = this
      axios({
        method: 'get',
        url: '/api/flow/getCarFlow',
        contentType: 'application/json; charset=utf-8'
      }).then(function (response) {
        if (response.data) {
          console.log(response.data)
          that.mockData = response.data
        }
      }).catch(function (response) {

      })
    }
  },
  filters: {
    pluralize: (n, w) => n === 1 ? w : (w + 's'),
    capitalize: s => s.charAt(0).toUpperCase() + s.slice(1)
  },
  created () {
    this.getTodosAsyc()
  }
}
</script>

<style scoped>
  /*.todoapp {*/
  /*text-align: center;*/
  /*}*/
  .header .header-title{
    color: rgba(240,45,45,0.1);
    font-size: 60px;
    text-align: center;
  }

  .header .header-body {
    font-size: 25px;
    width: 600px;
    margin: auto;
    border: 1px solid white;
    border-radius: 5px;
    padding: 20px;
    box-shadow: 10px 10px 5px #888888;
  }

  .new-todo {
    font-size: 25px;
    width: 90%;
    font-style: italic;
    border-style: hidden;
  }

  .new-todo:focus {
    outline:none;
  }

  #toggle-all {
    display: none;
  }

  .toggle-all:checked + label {
    color: rgba(0,0,0,0.1);
  }

  .toggle-all + label{
    cursor: pointer;
    margin-right: 5px;
  }

  .header label {
    font-size: 25px;
    z-index: 100;
  }

  .footer {
    width: 600px;
    /*border: 1px solid #eee;*/
    box-shadow: 3px 5px 5px #888888;
    margin: auto;
    padding: 20px
  }

  .filters {
    display: inline;
  }

  .filters li{
    display: inline-block;
    margin-left: 10px;
  }

  .selected {
    color: #3a8ee6;
  }

  .todo-count {

  }

  .clear-completed {
    border-style: hidden;
    background-color: white;
    font-style: oblique;
    cursor: pointer;
  }

  .main {
    width: 600px;
    margin: auto;
  }
</style>
