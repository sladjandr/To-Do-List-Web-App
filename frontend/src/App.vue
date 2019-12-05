<template>
  <div id="app">
    <button>Add new</button>
    <timeline />
    <modal-add-new />
  </div>
</template>

<script>
import Timeline from "./components/Timeline";
import ModalAddNew from "./components/ModalAddNew";
export default {
  name: 'app',
  components: {
    Timeline,
    ModalAddNew
  }
}
</script>

<style>

</style>
