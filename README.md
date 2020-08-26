# 说明
## 构建镜像
```shell script
export PATH_TO_FX=path/to/javafx-sdk-12/lib
export PATH_TO_FX_MODS=path/to/javafx-jmods-11
```
定义module-info.java文件，然后运行
```shell script
javac --module-path $PATH_TO_FX -d mods/hellofx $(find src/ -name "*.java")
# Or
javac --module-path $PATH_TO_FX_MODS -d mods/hellofx $(find src/ -name "*.java")
```
运行
```shell script
java --module-path $PATH_TO_FX:mods -m hellofx/hellofx.HelloFX
```
可以使用jlink创建自定义镜像
```shell script
# 创建
$JAVA_HOME/bin/jlink --module-path $PATH_TO_FX_MODS:mods --add-modules hellofx --output hellofx
# 运行
hellofx/bin/java -m hellofx/hellofx.HelloFX
```