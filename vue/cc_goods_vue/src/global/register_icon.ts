import {App} from 'vue'
import "element-plus/dist/index.css"

import {
  Expand,
  Fold,
  RefreshLeft,
  Search,
  Edit,
  DeleteFilled,
  WalletFilled,
  Tickets,
  Avatar,
  ColdDrink,
  RefreshRight,
  Select,
  Plus,
  EditPen,
  ZoomIn

} from "@element-plus/icons-vue"

const components = [
  Expand,
  Fold,
  RefreshLeft,
  Search,
  Edit,
  DeleteFilled,
  RefreshRight,
  WalletFilled,
  Tickets,
  Avatar,
  ColdDrink,
  Select,
  Plus,
  EditPen,
  ZoomIn
]

export default function(app: App): void {
  for(const svg of components) {
    app.component(svg.name, svg)
  }
}
