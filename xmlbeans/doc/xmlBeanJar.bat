@rem 生成的文件保存在lib目录下

@rem TODO (conf/xsd/ 下的文件名-不带后缀名)
set xsdFilename=customer

set xmlBeanBinPath=xmlbeans-2.6.0\bin

cd %xmlBeanBinPath%
scomp -out ..\..\..\lib\%xsdFilename%XmlBean.jar ..\..\..\bin\conf\xsd\%xsdFilename%.xsd ..\..\..\bin\conf\xsd\config\%xsdFilename%.xsdconfig