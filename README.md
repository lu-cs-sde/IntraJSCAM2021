|_**Repository**_|[![DOI](https://zenodo.org/badge/DOI/10.5281/zenodo.5296618.svg)](https://doi.org/10.5281/zenodo.5296618)|
|:------------|---------------|
|_**Docker image**_|[![DOI](https://zenodo.org/badge/DOI/10.5281/zenodo.5296449.svg)](https://doi.org/10.5281/zenodo.5296449)|
|_**Reserarch Object Badge**_ | <a href="https://icsme2021.github.io/cfp/AEandROSETrack.html">  <img  width="70"  src="resources/Open_Research.png"> </a>|
|_**Open Research Badge**_| <a href="https://icsme2021.github.io/cfp/AEandROSETrack.html"><img width="70"  src="resources/Research_Objects.png"> </a>|

---
<p align="center">
  <img width="300"  src="resources/logo.png">
</p>

This repository contains the artifact for the following paper:

* __[A Precise Framework for Source-Level Control-Flow Analysis](https://github.com/lu-cs-sde/IntraJSCAM2021/blob/main/intraj-preprint.pdf)__, _[Idriss Riouak π](https://orcid.org/0000-0003-3520-2262), [Christoph Reichenbach π](https://orcid.org/0000-0003-0608-7023), [GΓΆrel Hedin π](https://orcid.org/0000-0002-3003-2623) and [Niklas Fors π](https://orcid.org/0000-0003-2714-9457)_. _To appear at the 21st IEEE International Working Conference on Source Code Analysis & Manipulation, 2021 ([SCAM 2021 π](http://www.ieee-scam.org/2021))._

The repository contains:

* A snapshot of **IntraCFG** ([192c02c](https://github.com/lu-cs-sde/IntraJ/tree/192c02c4d37672b5d1ff6a595d67b404bab59e70)), i.e., a language-independent framework for building control-flow graphs (CFGs) using reference attribute grammars, as described in section 2 in the paper.
* A snapshot of **IntraJ** ([479e927](https://github.com/lu-cs-sde/IntraCFG/tree/479e9272809324296b623c6ff6872f216a10093d)), i.e., a tool that applies IntraCFG to construct control-flow graphs (CFGs) for Java source programs, as described in section 3 in the paper. IntraJ is built as an extension to the [ExtendJ](https://extendj.org) Java compiler, which is in turn implemented using [JastAdd](https://jastadd.org) (a metacompiler supporting reference attribute grammars).
* In addition to **CFG construction**, IntraJ contains two example client analyses that make use of the CFG, as described in section 4 in the paper: **DAA** - detection of Dead Assignments in the codebase, and **NPA** - detection of occurrences of Null Pointer exceptions.
* **Test cases** and **evaluation scripts** are also included. Using this artifact you can rerun the experiments presented in section 5 in the paper. This includes running IntraJ on a suite of subject codebases, and running competing tools (JastAddJ-Intraflow and SonarQube) on the same codebases.

You can **reuse** this artifact in various ways. For example:

* You can run IntraJ on other Java codebases (in Java-4, Java-5, Java-6, and Java-7) in order to construct CFGs and get DAA and NPA analysis results. More can be read about reusability [here](https://github.com/lu-cs-sde/IntraJSCAM2021/blob/main/REUSABILITY.md).

---
# Get the IntraJ artifact
We provide three different ways of getting and running **IntraJ**:
  * You can download the pre-built Docker image (recommended).  
  * Build your own Docker image using the Dockerfile script.
  * Download and build **IntraJ** from the artifact source code.

---
# Docker

We provide a [Docker](https://www.docker.com) image that contains *IntraJ* and evaluation scripts, packaged together with all the necessary dependencies.
To run such an image, make sure to install the relevant tools:

* For Windows and OS X systems, follow the guidelines on the [Docker desktop download site](https://www.docker.com/products/docker-desktop)

* On Linux-based systems, install the docker command-line tool. This tool may be provided by the docker.io and/or docker-ce packages. If your distribution does not provide these packages, follow the steps here:
  * For [Ubuntu](https://docs.docker.com/engine/install/ubuntu/)
  * For [Debian](https://docs.docker.com/engine/install/debian/)
  * For [CentOS](https://docs.docker.com/engine/install/centos/)
  * For [Fedora](https://docs.docker.com/engine/install/fedora/)
Users of other distributions can download [pre-compiled binaries](https://docs.docker.com/engine/install/binaries/) or build Docker from [source](https://github.com/docker) (both "cli" and "engine")


## Download pre-built Docker image
Download the pre-built image [here](https://zenodo.org/record/5296449/files/intraj_scam21.tar.gz).
Then, anywhere in your workspace run

```
docker load << Downloads/intraj_scam21.tar.gz
```

## Build your own Docker image
Clone the IntraJSCAM2021 repository by running the following command:
```
git clone https://github.com/lu-cs-sde/IntraJSCAM2021.git
```
Once you have cloned the repository
```
cd IntraJSCAM2021/Docker
docker build -t intraj:scam21 .
```

| β οΈ Note          |
|:---------------------------|
|It might take several minutes to build the Docker image.|
## Run the image

Run the image using:

```
docker run  -it --network="host" --expose 9000 --expose 9001 --memory="10g" --memory-swap="16g" intraj:scam21
```
| βοΈ Very Important βοΈ          |
|:---------------------------|
| SonarQube requires a high amount of memory. We tested the container with 10GByte of memory and 10GByte of swap memory. If you are running the container from Windows or Mac, the command-line options related to the available memory in the container (i.e., `--memory="10g"`, `--memory-swap="4g"`) are ignored. Please, set these two parameters from the GUI. Read more about it here:  [Windows](https://docs.docker.com/desktop/windows/) - [Mac](https://docs.docker.com/desktop/mac/)|


You will be logged in with the user _SCAM21_. Once logged in, run the following commands to launch the evaluation:

```
cd workspace/intraj/
./eval.sh 50 50

```
The results are saved in: `~/workspace/intraj/evaluation/YYYYMMDD_HHMMSS`

| β οΈ Note          |
|:---------------------------|
|The command `eval.sh 50 50` will run IntraJ 2500 times for each analysis. Therefore, computing the evaluation can take several hours.|


| βοΈ Very Important βοΈ         |
|:---------------------------|
 |Do not close the bash nor kill the container! The results will be lost!|

## Saving the results
To save the results in your own machine, run the following commands in a new bash:
```
> docker ps
```
This will print:
```
CONTAINER ID   IMAGE     COMMAND   CREATED   STATUS    PORTS     NAMES
4d882c86b5ab   intraj:scam21   "bash"    x   Up x seconds  random_name
```
With *your* CONTAINER ID run the following command:

```
docker cp 4d882c86b5ab:workspace/intraj/evaluation/YYYYMMDD_HHMMSS /PATH/IN/YOUR/MACHINE
```

# Build IntraJ from the source code
## Prerequisites

We have run IntraJ on the following Java version:

*  **Java SDK version 7**. (tested with  SDK 7.0.292-zulu. See [sdkman](https://sdkman.io)).

If you also want to run the competing tool SonarQube (for checking the evaluation section), you will additionally need the following Java version:

*  **Java SDK version 11** (tested with SDK 11.0.9.fx-zulu. See [sdkman](https://sdkman.io)).

It is possible to generate PDFs that show the CFGs visually. For this you need:
1) **Dot** (graphiz) - _PDF generation_
2) **Vim** - _PDF generation_
3) **Python3.x** with the following dependencies:
    * **PyPDF2 v1.26.0** - _PDF generation_
    * **numpy v1.20.1** - _Evaluation and Plots generation_
    * **pandas v1.2.4** - _Evaluation and Plots generation_
    * **matplotlib v3.3.4** - _Evaluation and Plots generation_
    * **seaborn v0.11.1** - _Evaluation and Plots generation_
    * **ipython v7.26.0** - _Evaluation and Plots generation_


The evaluation script uses `sdkman`.
To run the evaluation you need:
* The scripts `eval.sh` and `evaluation/run_eval.sh` uses `sdkman`. If you don't have `sdkman` installed but have Java SDK 7 installed, you can comment all the lines starting with `sdk` in `eval.sh` and in `evaluation/run_eval.sh`. You install `sdkman` by running the following commands:

  ```
  curl -s "https://get.sdkman.io" | bash
  source "$HOME/.sdkman/bin/sdkman-init.sh"
  sdk install java 7.0.292-zulu
  sdk use java 7.0.292-zulu
  ```

To install all the necessary Python dependencies, you can run the instruction described in the next section.


## Build
To clone the **IntraJ** code, run, in your working directory:
```
git clone https://github.com/lu-cs-sde/IntraJSCAM2021.git
```

Move to the **IntraJ** directory:

```
cd IntraJSCAM2021
```

To generate all the JARs necessary for the evaluation, execute

```
./gradlew build
```

To run all the tests, execute:

```
./gradlew test
```

### Python Dependencies

To install Python dependencies, you can execute the following instruction:

```
cd resources
pip3 install - requirements.txt
```

---



### Repository overview
The top-level structure of the repository:

    .
    βββ build                                # Compiled files
    βββ evaluation                           # Scripts and dependencies for evaluation
    βββ extendj                              # ExtendJ source code
    βββ resources                            # Scripts and logo
    βββ src                                  # IntraJ source code
    |    βββ jastadd                  
    |    |     βββ CFG                       # CFG spec in Jastadd
    |    |     βββ DataFlow                  # Data flow analyses spec
    |    βββ java
    |          βββ utils                     # General helpers for visualisation
    |          βββ test                      # JUnit test spec
    βββ tools                                # IntraJ source code
    |    βββ jastadd-2.3.6-custom            # Custom version of Jastadd
    βββ testfiles                            # Automated test files
    |    βββ DataFlow
    |    βββ CFG
    βββ eval.sh                              # Evaluation entry point
    βββ LICENSE
    βββ README.md

The _entry point_ of **IntraJ** (main) is defined in:
`extendj/src/fronted-main/org/extendj/IntraJ.java`.


### The _evaluation_ folder
The directory is structured as follow:

    .
    βββ antlr-2.7.2                          # ANTLR Benchmark                  (Paper Β§5)
    βββ pmd-4.2.5                            # PMD Benchmark                    (Paper Β§5)
    βββ jfreechar-1.0.0                      # JFC Benchmark                    (Paper Β§5)
    βββ fop-0.95                             # FOP Benchmark                    (Paper Β§5)
    βββ Results.xlsx                         # Analyses results in Excel        (Paper Β§5)
    βββ Results.htm                          # Analyses results in HTML
    βββ plots.py                             # Script that generates plots
    βββ run_eval.sh                          # Called by ../eval.sh
    βββ YYYYMMDD_HHMMSS                      # Evaluation results


### The _jastadd_ folder

    .
    βββ jastadd
         βββ CFG
         |    βββ IntraCFG
         |    |    βββ CFG.ast                # Lang-independent nodes
         |    |    βββ IntraCFG.jrag          # IntraCFG spec in Jastadd        (Paper Β§2.b)
         |    βββ java4                       #                                 (Paper Β§3)
         |    |    βββ Cache.jrag             # Cache settings
         |    |    βββ Exception.jrag         # Exception spec                  (Paper Β§3.c)
         |    |    βββ Initializer.jrag       # Initializers spec               (Paper Β§3.b)
         |    |    βββ Java4.jrag             # Java4 spec
         |    |    βββ ImplictNodes.ast       # Reified nodes
         |    βββ java5                       #                                 (Paper Β§3)
         |    |     βββ Java5.jrag            # Java5 spec
         |    βββ java7                       #                                 (Paper Β§3)
         |          βββ Java7.jrag            # Java7 spec
         βββ DataFlow                         # Data flow analyses spec         (Paper Β§4)
               βββ Analysis.jrag              # Collection attributes
               βββ DeadAssignment.jrag        # DAA spec                        (Paper Β§4.c)
               βββ LiveVariableAnalysis.jrag  # LVA spec                        (Paper Β§4.b)
               βββ NullAnalysis.jrag          # NPE sepc                        (Paper Β§4.a)
---

| β οΈ Note          |
|:---------------------------|
|There is no subdirectory for `java6`, since features introduced in Java 6 do not affect the construction of the CFG. |



## Available options to IntraJ:
  - `-help`: prints all the available options.
  - `-genpdf`: generates a pdf with AST structure of all the methods in the analysed files. It can be used combined with `-succ`,`-pred`.
  - `-succ`: generates a pdf with the successor relation for all the methods in the analysed files. It can be used combined with `-pred`.
  - `-pred`: generates a pdf with the predecessor relation for all the methods in the analysed files. It can be used combined with `-succ`.
  - `-statistics`: prints the number of _**CFGRoots**_, _**CFGNodes**_ and _**CFGEdges**_ in the analysed files.
  - `-nowarn`: the warning messages are not printed.

-------------- _ANALYSIS OPTIONS_ --------------------

Available analyses:
  * `DAA`: Detects unused dead assignments
  * `NPA`: Detects occurrences of Null Pointer Dereferencing

Options (where `id` corresponds to one of the analyses above):
   - `-Wid`: enable a given analysis, e.g., `-WDAA`
   - `-Wall`: enables all the available analyses
   - `-Wexcept=id`: enable all the available analyses except `id`, e.g., `-Wexcept=DAA`

---

# Example of running IntraJ

Suppose you would like to analyze a file `Example.java` located in your workspace:
```
public class Example {
  int example() {
    Integer m = null;
    m.toString();
    int x = 0;
    x = 1;
    return x;
  }
}
```
By running the following command:

```
    java -jar intraj.jar PATH/TO/Example.java -Wall -succ -statistics
```

**IntraJ** will print the following information
```
[NPA - PATH/TO/Example.java:4,4] The object 'm' may be null at this point.
[DAA - PATH/TO/Example.java:5,9] The value stored in 'x' is never read.
[INFO]: CFG rendering
[INFO]: DOT to PDF
[INFO]: PDF file generated correctly
[STATISTIC]: Elapsed time (CFG + Dataflow): 0.11s
[STATISTIC]: Total number
[STATISTIC]: Number roots:3
[STATISTIC]: Number CFGNodes:16
[STATISTIC]: Number Edges:13
[STATISTIC]: Largest CFG in terms of nodes:12
[STATISTIC]: Largest CFG in terms of edges:11
```

And the following PDF is generated:
![Example.pdf](resources/Example.png)

---
# How to run the evaluation
1) Follow the instructions in `"Prerequisites"` and `"Build"` above.
2) Run the command `./gradlew build`. This generates the following _jar_ files:
    - intraj.jar
    - intraj_bl.jar
    - intraj_cfg.jar
    - intraj_cfgdda.jar
    - intraj_dda.jar
3) Start the evaluation by executing `"zsh eval.sh N_iter_outerloop N_iter_innerloop"`.  For the paper we used `N_iter_outerloop = N_iter_innerloop = 50`.

All the results are stored in `evaluation/YYYYMMDD_HHMM`.


---
# Related repository repositories/links π
 - π **[IntraJ](https://github.com/lu-cs-sde/IntraJ)**: main repository for IntraJ (control-flow analysis for Java)
 - π **[IntraCFG](https://github.com/lu-cs-sde/IntraCFG)**: main repository for IntraCFG (language-independent framework for control-flow analysis)
 - π **[JastAdd](https://jastadd.org)**: meta-compilation system that supports Reference Attribute Grammars. We used a custom [JastAdd](https://bitbucket.org/jastadd/jastadd2/src/f00c118684f4cc9b42931b5a491046e41d68b6bf/) version which better supports interfaces.
 - π **[ExtendJ](https://extendj.org)**: extensible Java compiler built using JastAdd. We built **IntraJ** as an Static Analysis Extension of ExtendJ. More can be found [here](https://bitbucket.org/extendj/analysis-template/src/master/). 
 - π **[SonarQube](https://www.sonarqube.org/downloads/)**: platform developed by SonarSource for continuous inspection of code quality
 - π **[JastAddJ-Intraflow](https://bitbucket.org/jastadd/jastaddj-intraflow/src/master/)**: An earlier approach to implementing intra-procedural control flow, dataflow, and dead assignment analysis for Java, also using JastAdd.
