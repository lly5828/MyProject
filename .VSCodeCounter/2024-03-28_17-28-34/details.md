# Details

Date : 2024-03-28 17:28:34

Directory d:\\Automatic roll call system\\automatic

Total : 132 files,  25166 codes, 647 comments, 2690 blanks, all 28503 lines

[Summary](results.md) / Details / [Diff Summary](diff.md) / [Diff Details](diff-details.md)

## Files
| filename | language | code | comment | blank | total |
| :--- | :--- | ---: | ---: | ---: | ---: |
| [.eslintrc.js](/.eslintrc.js) | JavaScript | 7 | 0 | 1 | 8 |
| [.prettierrc.js](/.prettierrc.js) | JavaScript | 21 | 0 | 1 | 22 |
| [README.md](/README.md) | Markdown | 37 | 0 | 22 | 59 |
| [config/config.ts](/config/config.ts) | TypeScript | 56 | 97 | 4 | 157 |
| [config/defaultSettings.ts](/config/defaultSettings.ts) | TypeScript | 39 | 7 | 2 | 48 |
| [config/oneapi.json](/config/oneapi.json) | JSON | 593 | 0 | 1 | 594 |
| [config/proxy.ts](/config/proxy.ts) | TypeScript | 21 | 28 | 2 | 51 |
| [config/routes.ts](/config/routes.ts) | TypeScript | 37 | 33 | 2 | 72 |
| [jest.config.ts](/jest.config.ts) | TypeScript | 21 | 0 | 3 | 24 |
| [jsconfig.json](/jsconfig.json) | JSON with Comments | 11 | 0 | 1 | 12 |
| [mock/listTableList.ts](/mock/listTableList.ts) | TypeScript | 160 | 2 | 15 | 177 |
| [mock/notices.ts](/mock/notices.ts) | TypeScript | 113 | 0 | 3 | 116 |
| [mock/requestRecord.mock.js](/mock/requestRecord.mock.js) | JavaScript | 324 | 0 | 1 | 325 |
| [mock/route.ts](/mock/route.ts) | TypeScript | 5 | 0 | 1 | 6 |
| [mock/user.ts](/mock/user.ts) | TypeScript | 187 | 8 | 9 | 204 |
| [package.json](/package.json) | JSON | 104 | 0 | 1 | 105 |
| [pnpm-lock.yaml](/pnpm-lock.yaml) | YAML | 17,642 | 0 | 2,255 | 19,897 |
| [public/scripts/loading.js](/public/scripts/loading.js) | JavaScript | 179 | 4 | 20 | 203 |
| [src/access.ts](/src/access.ts) | TypeScript | 8 | 3 | 1 | 12 |
| [src/app.tsx](/src/app.tsx) | TypeScript JSX | 98 | 85 | 8 | 191 |
| [src/components/CardT/index.module.css](/src/components/CardT/index.module.css) | CSS | 21 | 0 | 2 | 23 |
| [src/components/CardT/index.tsx](/src/components/CardT/index.tsx) | TypeScript JSX | 30 | 0 | 2 | 32 |
| [src/components/Footer/index.tsx](/src/components/Footer/index.tsx) | TypeScript JSX | 33 | 0 | 3 | 36 |
| [src/components/HeaderDropdown/index.tsx](/src/components/HeaderDropdown/index.tsx) | TypeScript JSX | 23 | 0 | 5 | 28 |
| [src/components/RightContent/AvatarDropdown.tsx](/src/components/RightContent/AvatarDropdown.tsx) | TypeScript JSX | 105 | 5 | 14 | 124 |
| [src/components/RightContent/index.tsx](/src/components/RightContent/index.tsx) | TypeScript JSX | 28 | 0 | 4 | 32 |
| [src/components/Table/index.tsx](/src/components/Table/index.tsx) | TypeScript JSX | 72 | 1 | 2 | 75 |
| [src/components/index.ts](/src/components/index.ts) | TypeScript | 6 | 7 | 2 | 15 |
| [src/global.less](/src/global.less) | Less | 47 | 0 | 7 | 54 |
| [src/global.tsx](/src/global.tsx) | TypeScript JSX | 77 | 9 | 7 | 93 |
| [src/layout/index.tsx](/src/layout/index.tsx) | TypeScript JSX | 86 | 0 | 3 | 89 |
| [src/locales/bn-BD.ts](/src/locales/bn-BD.ts) | TypeScript | 24 | 0 | 2 | 26 |
| [src/locales/bn-BD/component.ts](/src/locales/bn-BD/component.ts) | TypeScript | 5 | 0 | 1 | 6 |
| [src/locales/bn-BD/globalHeader.ts](/src/locales/bn-BD/globalHeader.ts) | TypeScript | 17 | 0 | 1 | 18 |
| [src/locales/bn-BD/menu.ts](/src/locales/bn-BD/menu.ts) | TypeScript | 52 | 0 | 1 | 53 |
| [src/locales/bn-BD/pages.ts](/src/locales/bn-BD/pages.ts) | TypeScript | 70 | 0 | 1 | 71 |
| [src/locales/bn-BD/pwa.ts](/src/locales/bn-BD/pwa.ts) | TypeScript | 7 | 0 | 1 | 8 |
| [src/locales/bn-BD/settingDrawer.ts](/src/locales/bn-BD/settingDrawer.ts) | TypeScript | 31 | 0 | 1 | 32 |
| [src/locales/bn-BD/settings.ts](/src/locales/bn-BD/settings.ts) | TypeScript | 59 | 0 | 1 | 60 |
| [src/locales/en-US.ts](/src/locales/en-US.ts) | TypeScript | 23 | 0 | 2 | 25 |
| [src/locales/en-US/component.ts](/src/locales/en-US/component.ts) | TypeScript | 5 | 0 | 1 | 6 |
| [src/locales/en-US/globalHeader.ts](/src/locales/en-US/globalHeader.ts) | TypeScript | 17 | 0 | 1 | 18 |
| [src/locales/en-US/menu.ts](/src/locales/en-US/menu.ts) | TypeScript | 52 | 0 | 1 | 53 |
| [src/locales/en-US/pages.ts](/src/locales/en-US/pages.ts) | TypeScript | 70 | 0 | 1 | 71 |
| [src/locales/en-US/pwa.ts](/src/locales/en-US/pwa.ts) | TypeScript | 6 | 0 | 1 | 7 |
| [src/locales/en-US/settingDrawer.ts](/src/locales/en-US/settingDrawer.ts) | TypeScript | 31 | 0 | 1 | 32 |
| [src/locales/en-US/settings.ts](/src/locales/en-US/settings.ts) | TypeScript | 60 | 0 | 1 | 61 |
| [src/locales/fa-IR.ts](/src/locales/fa-IR.ts) | TypeScript | 23 | 0 | 2 | 25 |
| [src/locales/fa-IR/component.ts](/src/locales/fa-IR/component.ts) | TypeScript | 5 | 0 | 1 | 6 |
| [src/locales/fa-IR/globalHeader.ts](/src/locales/fa-IR/globalHeader.ts) | TypeScript | 17 | 0 | 1 | 18 |
| [src/locales/fa-IR/menu.ts](/src/locales/fa-IR/menu.ts) | TypeScript | 52 | 0 | 1 | 53 |
| [src/locales/fa-IR/pages.ts](/src/locales/fa-IR/pages.ts) | TypeScript | 69 | 0 | 1 | 70 |
| [src/locales/fa-IR/pwa.ts](/src/locales/fa-IR/pwa.ts) | TypeScript | 7 | 0 | 1 | 8 |
| [src/locales/fa-IR/settingDrawer.ts](/src/locales/fa-IR/settingDrawer.ts) | TypeScript | 32 | 0 | 1 | 33 |
| [src/locales/fa-IR/settings.ts](/src/locales/fa-IR/settings.ts) | TypeScript | 60 | 0 | 1 | 61 |
| [src/locales/id-ID.ts](/src/locales/id-ID.ts) | TypeScript | 24 | 0 | 2 | 26 |
| [src/locales/id-ID/component.ts](/src/locales/id-ID/component.ts) | TypeScript | 5 | 0 | 1 | 6 |
| [src/locales/id-ID/globalHeader.ts](/src/locales/id-ID/globalHeader.ts) | TypeScript | 17 | 0 | 1 | 18 |
| [src/locales/id-ID/menu.ts](/src/locales/id-ID/menu.ts) | TypeScript | 52 | 0 | 1 | 53 |
| [src/locales/id-ID/pages.ts](/src/locales/id-ID/pages.ts) | TypeScript | 72 | 0 | 1 | 73 |
| [src/locales/id-ID/pwa.ts](/src/locales/id-ID/pwa.ts) | TypeScript | 7 | 0 | 1 | 8 |
| [src/locales/id-ID/settingDrawer.ts](/src/locales/id-ID/settingDrawer.ts) | TypeScript | 32 | 0 | 1 | 33 |
| [src/locales/id-ID/settings.ts](/src/locales/id-ID/settings.ts) | TypeScript | 60 | 0 | 1 | 61 |
| [src/locales/ja-JP.ts](/src/locales/ja-JP.ts) | TypeScript | 23 | 0 | 2 | 25 |
| [src/locales/ja-JP/component.ts](/src/locales/ja-JP/component.ts) | TypeScript | 5 | 0 | 1 | 6 |
| [src/locales/ja-JP/globalHeader.ts](/src/locales/ja-JP/globalHeader.ts) | TypeScript | 17 | 0 | 1 | 18 |
| [src/locales/ja-JP/menu.ts](/src/locales/ja-JP/menu.ts) | TypeScript | 52 | 0 | 1 | 53 |
| [src/locales/ja-JP/pages.ts](/src/locales/ja-JP/pages.ts) | TypeScript | 69 | 0 | 1 | 70 |
| [src/locales/ja-JP/pwa.ts](/src/locales/ja-JP/pwa.ts) | TypeScript | 7 | 0 | 1 | 8 |
| [src/locales/ja-JP/settingDrawer.ts](/src/locales/ja-JP/settingDrawer.ts) | TypeScript | 31 | 0 | 1 | 32 |
| [src/locales/ja-JP/settings.ts](/src/locales/ja-JP/settings.ts) | TypeScript | 59 | 0 | 1 | 60 |
| [src/locales/pt-BR.ts](/src/locales/pt-BR.ts) | TypeScript | 21 | 0 | 2 | 23 |
| [src/locales/pt-BR/component.ts](/src/locales/pt-BR/component.ts) | TypeScript | 5 | 0 | 1 | 6 |
| [src/locales/pt-BR/globalHeader.ts](/src/locales/pt-BR/globalHeader.ts) | TypeScript | 17 | 0 | 1 | 18 |
| [src/locales/pt-BR/menu.ts](/src/locales/pt-BR/menu.ts) | TypeScript | 52 | 0 | 1 | 53 |
| [src/locales/pt-BR/pages.ts](/src/locales/pt-BR/pages.ts) | TypeScript | 72 | 0 | 1 | 73 |
| [src/locales/pt-BR/pwa.ts](/src/locales/pt-BR/pwa.ts) | TypeScript | 7 | 0 | 1 | 8 |
| [src/locales/pt-BR/settingDrawer.ts](/src/locales/pt-BR/settingDrawer.ts) | TypeScript | 32 | 0 | 1 | 33 |
| [src/locales/pt-BR/settings.ts](/src/locales/pt-BR/settings.ts) | TypeScript | 60 | 0 | 1 | 61 |
| [src/locales/zh-CN.ts](/src/locales/zh-CN.ts) | TypeScript | 23 | 0 | 2 | 25 |
| [src/locales/zh-CN/component.ts](/src/locales/zh-CN/component.ts) | TypeScript | 5 | 0 | 1 | 6 |
| [src/locales/zh-CN/globalHeader.ts](/src/locales/zh-CN/globalHeader.ts) | TypeScript | 17 | 0 | 1 | 18 |
| [src/locales/zh-CN/menu.ts](/src/locales/zh-CN/menu.ts) | TypeScript | 54 | 0 | 1 | 55 |
| [src/locales/zh-CN/pages.ts](/src/locales/zh-CN/pages.ts) | TypeScript | 67 | 0 | 1 | 68 |
| [src/locales/zh-CN/pwa.ts](/src/locales/zh-CN/pwa.ts) | TypeScript | 6 | 0 | 1 | 7 |
| [src/locales/zh-CN/settingDrawer.ts](/src/locales/zh-CN/settingDrawer.ts) | TypeScript | 31 | 0 | 1 | 32 |
| [src/locales/zh-CN/settings.ts](/src/locales/zh-CN/settings.ts) | TypeScript | 55 | 0 | 1 | 56 |
| [src/locales/zh-TW.ts](/src/locales/zh-TW.ts) | TypeScript | 21 | 0 | 2 | 23 |
| [src/locales/zh-TW/component.ts](/src/locales/zh-TW/component.ts) | TypeScript | 5 | 0 | 1 | 6 |
| [src/locales/zh-TW/globalHeader.ts](/src/locales/zh-TW/globalHeader.ts) | TypeScript | 17 | 0 | 1 | 18 |
| [src/locales/zh-TW/menu.ts](/src/locales/zh-TW/menu.ts) | TypeScript | 52 | 0 | 1 | 53 |
| [src/locales/zh-TW/pages.ts](/src/locales/zh-TW/pages.ts) | TypeScript | 67 | 0 | 1 | 68 |
| [src/locales/zh-TW/pwa.ts](/src/locales/zh-TW/pwa.ts) | TypeScript | 6 | 0 | 1 | 7 |
| [src/locales/zh-TW/settingDrawer.ts](/src/locales/zh-TW/settingDrawer.ts) | TypeScript | 31 | 0 | 1 | 32 |
| [src/locales/zh-TW/settings.ts](/src/locales/zh-TW/settings.ts) | TypeScript | 55 | 0 | 1 | 56 |
| [src/manifest.json](/src/manifest.json) | JSON | 22 | 0 | 1 | 23 |
| [src/pages/404.tsx](/src/pages/404.tsx) | TypeScript JSX | 16 | 1 | 3 | 20 |
| [src/pages/Admin.tsx](/src/pages/Admin.tsx) | TypeScript JSX | 8 | 44 | 6 | 58 |
| [src/pages/Course/index.tsx](/src/pages/Course/index.tsx) | TypeScript JSX | 10 | 9 | 2 | 21 |
| [src/pages/Home/index.module.css](/src/pages/Home/index.module.css) | CSS | 25 | 3 | 4 | 32 |
| [src/pages/Home/index.tsx](/src/pages/Home/index.tsx) | TypeScript JSX | 132 | 1 | 3 | 136 |
| [src/pages/Message/index.tsx](/src/pages/Message/index.tsx) | TypeScript JSX | 52 | 15 | 2 | 69 |
| [src/pages/Stu/Apply/index.tsx](/src/pages/Stu/Apply/index.tsx) | TypeScript JSX | 68 | 0 | 5 | 73 |
| [src/pages/Stu/Inquire/index.tsx](/src/pages/Stu/Inquire/index.tsx) | TypeScript JSX | 62 | 4 | 9 | 75 |
| [src/pages/TableList/components/UpdateForm.tsx](/src/pages/TableList/components/UpdateForm.tsx) | TypeScript JSX | 205 | 0 | 5 | 210 |
| [src/pages/TableList/index.tsx](/src/pages/TableList/index.tsx) | TypeScript JSX | 356 | 29 | 13 | 398 |
| [src/pages/Tea/Adjust/index.tsx](/src/pages/Tea/Adjust/index.tsx) | TypeScript JSX | 52 | 0 | 3 | 55 |
| [src/pages/Tea/Handle/index.tsx](/src/pages/Tea/Handle/index.tsx) | TypeScript JSX | 96 | 0 | 7 | 103 |
| [src/pages/User/Login/index.module.css](/src/pages/User/Login/index.module.css) | CSS | 33 | 1 | 4 | 38 |
| [src/pages/User/Login/index.tsx](/src/pages/User/Login/index.tsx) | TypeScript JSX | 111 | 7 | 6 | 124 |
| [src/requestErrorConfig.ts](/src/requestErrorConfig.ts) | TypeScript | 80 | 24 | 6 | 110 |
| [src/service-worker.js](/src/service-worker.js) | JavaScript | 37 | 22 | 7 | 66 |
| [src/services/ant-design-pro/api.ts](/src/services/ant-design-pro/api.ts) | TypeScript | 73 | 13 | 9 | 95 |
| [src/services/ant-design-pro/index.ts](/src/services/ant-design-pro/index.ts) | TypeScript | 6 | 4 | 1 | 11 |
| [src/services/ant-design-pro/login.ts](/src/services/ant-design-pro/login.ts) | TypeScript | 15 | 5 | 2 | 22 |
| [src/services/ant-design-pro/typings.d.ts](/src/services/ant-design-pro/typings.d.ts) | TypeScript | 84 | 7 | 12 | 103 |
| [src/services/swagger/index.ts](/src/services/swagger/index.ts) | TypeScript | 8 | 4 | 1 | 13 |
| [src/services/swagger/pet.ts](/src/services/swagger/pet.ts) | TypeScript | 121 | 17 | 16 | 154 |
| [src/services/swagger/store.ts](/src/services/swagger/store.ts) | TypeScript | 36 | 8 | 5 | 49 |
| [src/services/swagger/typings.d.ts](/src/services/swagger/typings.d.ts) | TypeScript | 79 | 16 | 18 | 113 |
| [src/services/swagger/user.ts](/src/services/swagger/user.ts) | TypeScript | 78 | 14 | 9 | 101 |
| [src/services/user/api.ts](/src/services/user/api.ts) | TypeScript | 41 | 37 | 16 | 94 |
| [src/services/user/login.ts](/src/services/user/login.ts) | TypeScript | 29 | 12 | 10 | 51 |
| [src/services/user/typing.d.ts](/src/services/user/typing.d.ts) | TypeScript | 42 | 34 | 4 | 80 |
| [src/typings.d.ts](/src/typings.d.ts) | TypeScript | 19 | 0 | 2 | 21 |
| [tests/setupTests.jsx](/tests/setupTests.jsx) | JavaScript JSX | 57 | 2 | 6 | 65 |
| [tsconfig.json](/tsconfig.json) | JSON with Comments | 23 | 0 | 1 | 24 |
| [types/cache/cache.json](/types/cache/cache.json) | JSON | 1 | 0 | 1 | 2 |
| [types/cache/login.cache.json](/types/cache/login.cache.json) | JSON | 386 | 0 | 1 | 387 |
| [types/cache/mock/login.mock.cache.js](/types/cache/mock/login.mock.cache.js) | JavaScript | 324 | 0 | 1 | 325 |
| [types/cache/mock/mock.cache.js](/types/cache/mock/mock.cache.js) | JavaScript | 0 | 0 | 1 | 1 |
| [types/index.d.ts](/types/index.d.ts) | TypeScript | 84 | 25 | 12 | 121 |

[Summary](results.md) / Details / [Diff Summary](diff.md) / [Diff Details](diff-details.md)