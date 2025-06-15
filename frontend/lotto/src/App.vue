<template>
  <router-view></router-view>
</template>

<script>
import { defineComponent } from 'vue';

export default defineComponent({
  name: 'App',
});
</script>

<style>
.mainbody {
  color: white;
  min-height: 100vh;
}
#app {
  text-align: center;
}
</style>
