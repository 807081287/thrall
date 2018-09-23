<style scoped>
  .layout {
    border: 1px solid #d7dde4;
    background: #f5f7f9;
    position: relative;
    border-radius: 4px;
    overflow: hidden;
  }

  .layout-logo {
    width: 100px;
    height: 30px;
    border-radius: 3px;
    float: left;
    position: relative;
    font-size: large;
    top: 5px;
    left: 10px;
  }

  .layout-nav {
    margin: 0 auto;
    float: right;
    position: relative;
    top: 5px;
    left: 10px;
  }

  .layout-footer-center {
    text-align: center;
  }
</style>
<template>
  <div class="layout">
    <Layout>
      <Header>
        <Menu mode="horizontal" theme="dark" active-name="1">
          <div class="layout-logo">
            <p style="color: white;">管理系统</p>
          </div>
          <div class="layout-nav">
            <MenuItem name="4">
              <Dropdown>
                <Avatar style="background-color: #87d068" icon="ios-person"/>
                <Icon type="ios-arrow-down"></Icon>
                <DropdownMenu slot="list">
                  <DropdownItem>个人信息</DropdownItem>
                  <DropdownItem>修改密码</DropdownItem>
                  <DropdownItem>注销</DropdownItem>
                </DropdownMenu>
              </Dropdown>
            </MenuItem>
          </div>
        </Menu>
      </Header>
      <Layout :style="{padding: '0 0'}">
        <Content :style="{padding: '0 0', minHeight: '200px', background: '#fff'}">
          <Layout>
            <Sider hide-trigger :style="{background: '#fff'}">
              <Menu active-name="1-2" theme="dark" width="auto" :open-names="['1']">
                <MenuGroup title="菜单"></MenuGroup>
                <MenuItem name="1">
                  <Icon type="md-document"/>
                  系统主页
                </MenuItem>
                <Submenu name="1">
                  <template slot="title">
                    <Icon type="ios-navigate"></Icon>
                    用户管理
                  </template>
                  <MenuItem name="1-1">超级管理员</MenuItem>
                  <MenuItem name="1-2">一般管理员</MenuItem>
                  <MenuItem name="1-3">普通用户</MenuItem>
                </Submenu>
                <Submenu name="2">
                  <template slot="title">
                    <Icon type="ios-keypad"></Icon>
                    信息管理
                  </template>
                  <MenuItem name="2-1">部门</MenuItem>
                  <MenuItem name="2-2">项目组</MenuItem>
                </Submenu>
                <Submenu name="3">
                  <template slot="title">
                    <Icon type="ios-analytics"></Icon>
                    数据分析
                  </template>
                  <MenuItem name="3-1">收支分析</MenuItem>
                  <MenuItem name="3-2">利润分析</MenuItem>
                </Submenu>
                <MenuItem name="2">
                  <Icon type="md-chatbubbles"/>
                  报表导出
                </MenuItem>
                <MenuItem name="2">
                  <Icon type="md-chatbubbles"/>
                  系统设置
                </MenuItem>
              </Menu>
            </Sider>
            <Content :style="{padding: '24px', minHeight: '280px', background: '#fff'}">
              Content
            </Content>
          </Layout>
        </Content>
      </Layout>
      <Footer class="layout-footer-center">2018 &copy; Huyida</Footer>
    </Layout>
  </div>
  </div>
</template>
<script>
  export default {}
</script>
