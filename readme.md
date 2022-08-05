



mysql没有自启动导致查询无结果

whitepage error
- 以为路由有问题, 在主页面返回字符串无问题
- 切换到controller返回字符串无问题
- 返回list<user>有问题, 无法序列化, 返回单个user报406
- 最后是lombok的问题

rest client发起post请求测试，没有设置content-type报错

设置mybaits.xml文件, 设置动态sqlm, 解决全更新问题.  
xml比注解更...

解决跨域问题

@jsonignore 忽略某个字段，不展示给前端

v-model绑定表单查询

mybatis plus默认用实体类的小写当成表名, 不一样需要注解. table id在实体类id不叫id的情况下需要. table filed设置别名, 可以属性名跟数据库不一致.

<!-- querry warpper需要传参, null也不行. -->
没注释掉原来的mapper, 直接重写了导致出不来.

设置查询字段默认值为空格字符时, %%查不出来东西, 需要加判断

使用axios代替fetch, 避免格式json等繁琐代码

前后端变量不一样, 通过查询log日志看sql找到

计算属性忘了加this

slot-scope获取行

在浏览器中，因为XMLHttpRequest规范的限制，浏览器中ajax发送的http请求，get，delete请求不能携带实体。

org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'userController': Injection of resource dependencies failed; nested exception is org.springframework.beans.factory.BeanNotOfRequiredTypeException: Bean named 'userService' is expected to be of type 'com.plw.springboot.service.IUserService' but was actually of type 'com.plw.springboot.service.UserService$$EnhancerBySpringCGLIB$$c1d410bb'


用户名异常刚抛出就被捕获