本项目包含:
    1.基于接口的jdk动态代理:
        生成的代理对象和需要被代理的目标对象属于兄弟关系,所以需要采用多态的形式用他们共同的接口接收返回值.
    2.cglib动态代理:
        1).cglib的jar包注意事项:
            spring-context-->依赖了spring-core等-->spring-core依赖了cglib等,所以只需要导入spring-context的pom即可.
        2).cglib生成的代理对象和目标对象是子父关系,所以需要采用多态的形式用目标对象接收返回值.