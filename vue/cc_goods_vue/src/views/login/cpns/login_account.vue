<template>
  <div class="login-account">
    <el-form :model="account" label-width="auto" :rules="formRules" ref="formRef">
      <el-form-item label="用户名" prop="username">
        <el-input v-model="account.username" />
      </el-form-item>
      <el-form-item label="密码" prop="password">
        <el-input  v-model="account.password" show-password/>
      </el-form-item>
      <div class="verifyCode">
        <el-form-item label="验证码" prop="verifyCode" class="formItem">
          <el-input v-model="account.verifyCode" />
        </el-form-item>
        <img :src="imgUrl" class="verifyImg" @click="changeCode()" ref="imgRef"/>
      </div>
    </el-form>
    <div class="linkApass">
      <el-checkbox v-model="isRemember" label="记住密码" />
      <el-link type="primary">忘记密码</el-link>
    </div>
    <el-button type="primary" @click="loginClick">登录</el-button>
  </div>
</template>

<script lang="ts" setup>
import { ref, reactive, computed } from 'vue'
import { useStore } from 'vuex'
import { ElForm } from 'element-plus/lib/components'
import localCache from '@/utils/cache'
import { formRules } from '../config/form_rules'
import { getCodeRequest, verifyCodeRequest } from '@/service/login'

const store = useStore()
const imgRef = ref()

const formRef = ref<InstanceType<typeof ElForm>>()
const account = reactive({
  username: localCache.getCache('username') ?? '',
  password: localCache.getCache('password') ?? '',
  verifyCode: ''
})
const isRemember = ref(true)
let imgUrl = ref(localCache.getCache('imgUrl'))

const changeCode = async () => {
  localStorage.removeItem('imgUrl')
  account.verifyCode = ''
  const blobRes = await getCodeRequest()
  const blob = new Blob([blobRes])
  const url = window.URL.createObjectURL(blob);
  imgRef.value.src = url
}

const loginClick = () => {
  formRef.value?.validate(async (valid) => {
    if(valid) {
      const res = await verifyCodeRequest(account.verifyCode)
      if(res.code === 401) {
        changeCode()
        return
      }
      if(res.code !== 200) return
      const username = account.username
      const password = account.password
      if(isRemember.value) {
        localCache.setCache('username', username)
        localCache.setCache('password', password)
      } else {
          localCache.deleteCache('username')
          localCache.deleteCache('password')
      }
      store.dispatch('login/accountLoginAction', { username, password })
    }
  })
}

</script>

<style scoped lang="less">
.linkApass {
  display: flex;
  justify-content: space-between;
}
.el-button {
  width: 100%;
  margin-top: 15px;
}

img {
  position: absolute;
  top: 50%;
  transform: translateY(45%);
  left: 53%;
}

::v-deep .formItem {
  width: 62% !important;
}
</style>
