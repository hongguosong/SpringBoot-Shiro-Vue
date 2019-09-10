<template>
    <li class="todo" :class="{ completed: todo.done, editing: editing }">
      <span class="date">{{todo.date}}</span>
      <label class="toggle-father">
        <input class="toggle-me"
               type="checkbox"
               :checked="todo.done"
               @change="toggleTodoAsyc({todo: todo})"/>
        <div class="toggle"></div>
        <label class="toggle-label" v-text="todo.text" @dblclick="editing = true" v-show="!editing"></label>
      </label>
      <button class="destroy" @click="deleteTodoAsyc({ todo: todo })">×</button>

      <input class="edit"
         v-show="editing"
         v-focus="editing"
         :value="todo.text"
         @keyup.enter="doneEdit"
         @keyup.esc="cancelEdit"
         @blur="doneEdit"/>
    </li>
</template>

<script>
import { mapMutations, mapActions } from 'vuex'

export default {
  name: 'todo',
  props: ['todo'],
  data () {
    return {
      editing: false
    }
  },
  directives: {
    focus (el, { value }, { context }) {
      if (value) {
        console.log(context)
        context.$nextTick(() => {
          el.focus()
        })
      }
    }
  },
  methods: {
    ...mapMutations([
      'editTodo',
      'toggleTodo',
      'deleteTodo'
    ]),
    ...mapActions([
      'toggleTodoAsyc',
      'deleteTodoAsyc',
      'editTodoAsyc'
    ]),
    doneEdit (e) {
      const value = e.target.value.trim()
      const { todo } = this
      if (!value) {
        this.deleteTodoAsyc({
          todo
        })
      } else if (this.editing) {
        this.editTodoAsyc({
          todo, value
        })
        this.editing = false
      }
    },
    cancelEdit (e) {
      e.target.value = this.todo.text
      this.editing = false
    }
  }
}
</script>

<style scoped>
  .todo {
    list-style-type: none;
    /*border: 1px solid #eee;*/
    box-shadow: 3px 5px 5px #888888;
    padding: 10px;
    margin-left: -40px;
    height: 50px;
  }

  .date {
    font-size: 8px;
    width: 50px;
    float: left;
    padding: 6px 0;
  }

  .toggle {
    width: 25px;
    height: 25px;
    border: 1px solid #eee;
    border-radius: 100%;
    background: #ddd;
    /* position: relative; */
    display: inline-block;
    margin-top: 2.5px;
  }

  .toggle-me {
    opacity: 0;
    display: none;
    height: 25px;
  }

  .toggle-label {
    font-size: 25px;
  }

  input:checked + .toggle {
    border-color: #5daf34;
  }

  input:checked + .toggle + label {
    text-decoration: line-through;
  }

  .destroy {
    float: right;
    color: indianred;
    border-style: none;
    background-color: white;
    /* border-radius: 100%; */
    font-size: 25px;
    padding: 0 6.7px;
  }

  .edit {
    font-size: 25px;
    outline: none;
    border: none;
  }
</style>
