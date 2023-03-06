import { ElMessage, MessageParams, messageType } from 'element-plus/lib/components'

const showMessage = Symbol('showMessage')
class DomMessage {
    success(options: MessageParams, single = true) {
        this[showMessage]('success', options, single)
    }
    warning(options: MessageParams, single = true) {
        this[showMessage]('warning', options, single)
    }
    info(options: MessageParams, single = true) {
        this[showMessage]('info', options, single)
    }
    error(options: MessageParams, single = true) {
        this[showMessage]('error', options, single)
    }

    [showMessage](type: messageType, options: MessageParams, single: boolean) {
        if (single) {
            // 判断是否已存在Message
            if (document.getElementsByClassName('el-message').length === 0) {
                ElMessage[type](options)
            }
        } else {
          ElMessage[type](options)
        }
    }
}
export default new DomMessage()
