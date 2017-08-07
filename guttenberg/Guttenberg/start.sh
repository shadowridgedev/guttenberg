firewall-cmd --permanent --zone=public --add-port=8764/tcp 
firewall-cmd --permanent --zone=public --add-port=8765/tcp 
firewall-cmd --permanent --zone=public --add-port=8766/tcp 
firewall-cmd --permanent --zone=public --add-port=8769/tcp 
firewall-cmd --permanent --zone=public --add-port=8984/tcp 
firewall-cmd --permanent --zone=public --add-port=8983/tcp 
firewall-cmd --permanent --zone=public --add-port=9983/tcp 
firewall-cmd --permanent --zone=public --add-port=80/tcp 
firewall-cmd --permanent --zone=public --add-port=22/tcp 
firewall-cmd --permanent --zone=public --add-port=8080/tcp 
 

firewall-cmd --reload
mv /home/cloudera/sys/
mv /home/cloudera/sys/fusion/3.0.0/fusion /home/cloudera/
 ./home/cloudera/fusion/bin/fusion
