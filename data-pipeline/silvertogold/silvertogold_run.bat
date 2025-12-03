%~d0
cd %~dp0
java -Dtalend.component.manager.m2.repository="%cd%/../lib" -Xms256M -Xmx1024M -cp .;../lib/routines.jar;../lib/log4j-slf4j-impl-2.13.2.jar;../lib/log4j-api-2.13.2.jar;../lib/log4j-core-2.13.2.jar;../lib/jboss-marshalling-2.0.12.Final.jar;../lib/dom4j-2.1.3.jar;../lib/mongo-java-driver-3.12.0.jar;../lib/postgresql-42.2.14.jar;../lib/slf4j-api-1.7.29.jar;../lib/crypto-utils-0.31.12.jar;silvertogold_0_1.jar; local_project.silvertogold_0_1.silvertogold --context=Default %*
