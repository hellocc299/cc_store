<template>
  <div class="goods">
    <el-card>
      <PageSearch :searchTitle="'商品'"
                  :searchFormConfig="GoodsSearchConfig"
                  @queryBtnClick="queryBtnClick"></PageSearch>
    </el-card>
    <el-card class="goods-content">
      <cc-table
        :listData="goodsList"
        :listCount="goodsCount"
        v-bind="GoodsContentConfig"
        v-model:page="pageInfo">
        <template #headerHandler>
          <el-button @click="createLabel">{{ newLabels }}</el-button>
          <el-button type="primary" @click="createGoods">{{ newGoods }}</el-button>
          <create-modal :modelValue="centerDialogVisible"
                        @update:modelValue="(newValue) => (centerDialogVisible = newValue)"
                        :title="newGoods"
                        :createModalConfig="GoodsCreateConfig"
                        :createDefaultInfo="createDefaultInfo"
                        @handleConfirmClick="confirmClick"></create-modal>
          <create-modal :modelValue="classifyDialogVisible"
                        @update:modelValue="(newValue) => (classifyDialogVisible = newValue)"
                        :title="newLabels"
                        :createModalConfig="ClassifyCreateConfig"
                        :createDefaultInfo="classifyCreateDefault"
                        @handleConfirmClick="classifyConfirmClick"></create-modal>
        </template>
        <template #isPull="scope">
          <el-button plain
                   size="default"
                   type="success"
                   v-if="scope.row.isPull === 0">上新</el-button>
          <el-button plain
                   size="default"
                   type="danger"
                   v-if="scope.row.isPull === 1">下架</el-button>
        </template>
        <template #img="scope">
          <el-image
          style="width: 100px; height: 100px"
          :src="scope.row.img"
          fit="cover"/>
        </template>
        <template #handle="scope">
          <div class="handle-btns">
            <el-button type="primary"
                       link
                       @click="hanleEditGoods(scope.row)"
                       size="small"><el-icon><edit /></el-icon>编辑</el-button>

            <el-button type="danger"
                       link
                       @click="handleDeleteClick(scope.row)"
                       size="small"><el-icon><delete-filled /></el-icon>删除</el-button>
          </div>
        </template>
      </cc-table>
      <edit-modal :modelValue="editDialogVisible"
                  @update:modelValue="(newValue) => (editDialogVisible = newValue)"
                  :title="editTitle"
                  :editModalConfig="GoodsEditConfig"
                  :editDefaultInfo="editDefaultInfo"
                  @handleConfirmClick="editConfirmClick" />
    </el-card>
  </div>
</template>

<script lang="ts" setup>
import { ref, watch, computed } from 'vue'
import { useStore } from '@/store'
import cache from '@/utils/cache'
import Message from '@/common_ui/message'
import PageSearch from '@/components/page_search/page_search.vue'
import CcTable from '@/common_ui/table/table.vue'
import CreateModal from '@/components/page_modal/create_modal.vue'
import EditModal from '@/components/page_modal/edit_modal.vue'
import { GoodsSearchConfig } from './config/goods_search_config'
import { GoodsCreateConfig } from './config/goods_create_config'
import { GoodsContentConfig } from './config/goods_content_config'
import { ClassifyCreateConfig } from './config/classify_create_config'
import { GoodsEditConfig } from './config/goods_edit_config'
import { uploadImgRequest, updateGoodsRequest, updateImgRequest, deleteGoodsRequest } from '@/service/goods'
import { IGoodsShowState } from '@/store/goods/type'

// classify
const store = useStore()
store.dispatch('classify/getAllClassifies')

watch(
  () => store.state.classify.classifies,
  (newValue) => {
    const classifyOptions = newValue.map((value: any) => {
      return { label: value.name, value: value.classifyId }
    })
    cache.setCache('classifyOptions', classifyOptions)
  }
)

const newGoods = '新建商品'
const newLabels = '新建标签'

const createDefaultInfo = ref({})
const classifyCreateDefault = ref({})
const centerDialogVisible = ref(false)
const classifyDialogVisible = ref(false)

const createGoods = () => {
  createDefaultInfo.value = {};
  centerDialogVisible.value = true
}
const createLabel = () => {
  classifyCreateDefault.value = {};
  classifyDialogVisible.value = true
}
const confirmClick = async (value: any) => {
  if(!value['img']) {
    Message.error('请上传图片')
    return
  }
  store.dispatch('goods/insertGoodsAction', value)
}
const classifyConfirmClick = async (value: any) => {
  if(!value['img']) {
    Message.error('请上传图片')
    return
  }
  classifyDialogVisible.value = false
  store.dispatch('classify/insertClassifyAction', { img: value.img.raw, classify: value.classify})
}

// table
const pageInfo = ref({ currentPage: 1, pageSize: 10 })
watch(pageInfo, () => {
  getPageData({classifyId: 0})
})

// get goods info
const getPageData = (queryInfo: any = {}) => {
  store.dispatch('goods/findGoodsByCondiction', {
    queryInfo: {
      ...queryInfo,
      page: pageInfo.value.currentPage - 1,
      size: pageInfo.value.pageSize
    }
  })
}
getPageData({classifyId: 0})

const goodsList = computed(() => store.state.goods.goodsShowList)
const goodsCount = computed(() => store.state.goods.count)

const queryInfo = { name: null, classifyId: 0, page: pageInfo.value.currentPage, size: pageInfo.value.pageSize }

// edit
const editTitle = '编辑商品'
const editDialogVisible = ref(false)
const editDefaultInfo = ref<IGoodsShowState | any>({})

const hanleEditGoods = (item: any) => {
  editDefaultInfo.value = { ...item }
  editDialogVisible.value = true
}
const editConfirmClick = async (value: any) => {
  editDialogVisible.value = false
  if(!value['img']) {
    Message.error('请上传图片')
  }
  if(typeof value.img !== 'string') {
    const imgUrl = await uploadImgRequest({file: value['img'].raw})
    const imgId = editDefaultInfo.value.imgId
    await updateImgRequest(imgId, imgUrl)
  }
  const editGoodsVO = {
    goodsId: editDefaultInfo.value.id,
    name: value.name,
    classifyId: value.classifyId,
    isPull: value.isPull,
    description: value.description,
    price: value.price
  }
  await updateGoodsRequest(editGoodsVO)
  store.dispatch('goods/findGoodsByCondiction', queryInfo)
}

const handleDeleteClick = async (item: any) => {
  await deleteGoodsRequest(item.id)
  store.dispatch('goods/findGoodsByCondiction', queryInfo)
}

// page search
const queryBtnClick = (formData: any) => {
  let classifyId = formData['classifyId'];
  const name = formData.name
  if(classifyId === "") {
    classifyId = 0
  }
  store.dispatch('goods/findGoodsByCondiction', { name, classifyId, ...pageInfo })
}

</script>

<style scoped lang="less">
.goods {
  .goods-content {
    margin-top: 30px;
  }

  ::v-deep .handle-btns {
    .el-button--small {
      padding: 0px 2px;
    }
  }
}
</style>
