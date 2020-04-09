## Ubuntu utility commands

###The general syntax of the /etc/apt/sources.list file takes the following format:

- deb http://repo.tld/ubuntu distro component...

- The first entry in the line defines the type of the archive. The archive type can be either deb or deb-src. Deb implies that the repository contains .deb packages while deb-src implies source packages.
- The second entry is the repository URL.
- The third entry specifies the distribution code name, such as beaver, xenial and so on.
- The last entries are the repository components or categories. The default Ubuntu repositories are split into four components - main, restricted, universe and multiverse. Generally, third-party repositories have only one category.


### Apt Sources

- How to check list of repository apt get is checking

```shell script
apt-cache policy

cat /etc/apt/sources.list /etc/apt/sources.list.d/*

# My Choice
apt-cache policy | grep http | awk '{print $2 $3}' | sort -u

grep ^ /etc/apt/sources.list /etc/apt/sources.list.d/* 

grep -r --include '*.list' '^deb ' /etc/apt/sources.list /etc/apt/sources.list.d/
grep -r --include '*.list' '^deb ' /etc/apt/ | sed -re 's/^\/etc\/apt\/sources\.list((\.d\/)?|(:)?)//' -e 's/(.*\.list):/\[\1\] /' -e 's/deb http:\/\/ppa.launchpad.net\/(.*?)\/ubuntu .*/ppa:\1/'

```

### Uninstall

```shell script
sudo add-apt-repository --remove <repository>
sudo apt-get purge package_name
```

[More on APT](https://linuxize.com/post/how-to-add-apt-repository-in-ubuntu/)