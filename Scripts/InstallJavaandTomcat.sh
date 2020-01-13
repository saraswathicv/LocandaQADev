#!/bin/bash
present_directory=`pwd`
if [ -z `yum list installed | grep java-1.8.0-openjdk-devel` ]
then
	echo "JAVA is not installed, installing now..."
	sudo yum install java-1.8.0-openjdk-devel -y
fi

export JAVA_HOME=`ls -lrt | grep "^d" | awk '{print $9}' | grep 'java-1.8.0-openjdk'`
if [ -z $JAVA_HOME ]
then
   echo "JAVA Not installed successfully please check something went wrong"
   exit 1;
fi
if [ -z `which wget` ]
then
	echo " wget is not installed, installing now..."
	sudo yum -y wget
fi

sudo cd /usr/local
wget http://mirrors.estointernet.in/apache/tomcat/tomcat-8/v8.5.38/bin/apache-tomcat-8.5.38.tar.gz
tar -xvf apache-tomcat-8.5.38.tar.gz 
export CATALINA_HOME=/usr/local/apache-tomcat-8.5.38
if ! [ -d /usr/local/apache-tomcat-8.5.38 ]
then
	echo "Tomcat not installed properly please check"

fi
export PATH=$PATH:$CATALINA_HOME/bin:$JAVA_HOME
cd $present_directory
cp target/*.war /usr/local/apache-tomcat-8.5.38/webapps
cp context.xml /usr/local/apache-tomcat-8.5.38/webapps/manager/META-INF
cp tomcat-users.xml /usr/local/apache-tomcat-8.5.38/conf
