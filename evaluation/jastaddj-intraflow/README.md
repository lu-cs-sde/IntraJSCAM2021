JastAddJ-IntraFlow
==================

An extension to the JastAdd extensible Java compiler (JastAddJ) adding intra-procedural control flow, dataflow, and dead assignment analysis on top of the abstract syntax tree. This approach is described in more detail in the following paper:

 * __Extensible Intraprocedural Flow Analysis at the Abstract Syntax Tree Level__  
   _Emma Söderberg, Torbjörn Ekman, Görel Hedin, Eva Magnusson_   
   Science of Computer Programming, Elsevier Science B. V.,  
   Volume 78, Issue 10, 1 October 2013, Pages 1809–1827  
   [Download paper here](http://dx.doi.org/10.1016/j.scico.2012.02.002)

Latest stable version
---------------------

The flow analysis modules were originally developed for Java 5. In this repo we are in the process of automating the tests. We then plan to extend the modules to support also Java 6, 7, 8.

The latest stable version is the following:

    jastaddj-intraflow: 22e7cb1 2013-10-28

It does not work with later versions of jastaddj than the following:

    jastaddj: aedcfa4 2014-06-04

To try out the latest stable version, clone out jastaddj-intraflow and jastaddj in sibling directories:

    cd git
    git clone git@bitbucket.org:jastadd/jastaddj-intraflow.git
    git clone git@bitbucket.org:jastadd/jastaddj.git

Then create a soft link to the location of jastadd2.jar (also as a sibling)

    cd git
    ln -s jastaddj/tools jastadd2

(Alternatively, create a dir called `jastadd2`, and copy jastadd2.jar from jastaddj/tools/jastadd2.jar to that dir.)

Then checkout the stable versions:

    cd jastaddj
    git checkout aedcfa4
    ...
    cd jastaddj-intraflow
    git checkout 22e7cb1

You should now be able to build and run the tests:

    cd jastaddj-intraflow
    ant
    ant test

License & Copyright
-------------------

 * Copyright (c) 2007-2013, JastAddJ-IntraFlow Committers

All rights reserved.

JastAddJ-IntraFlow is covered by the Modified BSD License. 
The full license text is distributed with this software. 
See the `LICENSE` file.

Building
--------

The build file is configured to look for the Java1.4Frontend and Java1.5Frontend
 modules from the JastAddJ compiler specification. The paths to these modules are configured in the top of the `build.xml` file. 

To do a basic build with liveness analysis turned on run:

      $ ant 

By editing the `build.xml` file, you can choose to include reaching definition ana
lysis as well. The section in the `build.xml` file to edit is marked with comments
. 

For dead assignment detection using liveness analysis include the `spec/JavaDeadAssigns.jrag` file:

    <fileset dir="spec">
      ...
      <include name="JavaDeadAssigns.jrag" />
      ...
    </fileset>

For liveness analysis and reaching definition include the `spec/JavaReaching1.4.jrag` and `spec/JavaDeadAssignsReaching.jrag` files:

    <fileset dir="spec">
      ...
      <include name="JavaReaching1.4.jrag" />
      <include name="JavaDeadAssignsReaching.jrag" />
      ...
    </fileset>

NB! You can only include one of the files "spec/JavaDeadAssigns.jrag" and "spec/JavaDeadAssignsReaching.jrag".