<template>
  <div class="login">
    <login-panel />
  </div>
</template>

<script lang="ts" setup>
import LoginPanel from './cpns/login_panel.vue';

</script>

<style scoped lang="less">
.login {
  display: flex;
  justify-content: center;
  align-items: center;
  width: 100%;
  height: 100%;
  background: url('../../assets/img/login-bg.svg') no-repeat;
	background-size:100% 100%;
	background-attachment:fixed;
}

</style>