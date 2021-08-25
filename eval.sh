#!/bin/zsh

echo "\u001b[33;1m[INFO] SETTING ENVIRONMENT \u001b[0m"
. ~/.sdkman/bin/sdkman-init.sh
sdk use java 7.0.292-zulu
set -e

N_ITER=$1
N_ITER_SS=$2
CLASSPATH_ANTLR=":"
CLASSPATH_FOP="fop-0.95/lib/fop-all.jar:fop-0.95/lib/aspectjrt.jar:fop-0.95/lib/xmlgraphics-commons-1.3.1.jar:fop-0.95/lib/xml-resolver-1.2.jar:fop-0.95/lib/commons-cli-1.2.jar:fop-0.95/lib/fop-0.20.5.jar:fop-0.95/lib/jai_core-1.1.3.jar:fop-0.95/lib/apache-ant-1.8.2.jar"
CLASSPATH_PMD="pmd-4.2.5/lib/asm-3.1.jar:pmd-4.2.5/lib/javacc.jar:pmd-4.2.5/lib/jaxen-1.1.1.jar:pmd-4.2.5/lib/junit-4.4.jar:fop-0.95/lib/fop-all.jar:fop-0.95/lib/aspectjrt.jar:fop-0.95/lib/xmlgraphics-commons-1.3.1.jar:fop-0.95/lib/xml-resolver-1.2.jar:fop-0.95/lib/commons-cli-1.2.jar:fop-0.95/lib/fop-0.20.5.jar:fop-0.95/lib/jai_core-1.1.3.jar:fop-0.95/lib/apache-ant-1.8.2.jar"
CLASSPATH_JFREECHART="jfreechart-1.0.0/lib/servlet.jar:jfreechart-1.0.0/lib/orsonpdf-1.6-eval.jar:jfreechart-1.0.0/lib/orsoncharts-1.4-eval-nofx.jar:jfreechart-1.0.0/lib/junit-4.11.jar:jfreechart-1.0.0/lib/jfreesvg-1.9.jar:jfreechart-1.0.0/lib/jcommon-1.0.22.jar:jfreechart-1.0.0/lib/hamcrest-core-1.3.jar:fop-0.95/lib/fop-all.jar:fop-0.95/lib/aspectjrt.jar:fop-0.95/lib/xmlgraphics-commons-1.3.1.jar:fop-0.95/lib/xml-resolver-1.2.jar:fop-0.95/lib/commons-cli-1.2.jar:fop-0.95/lib/fop-0.20.5.jar:fop-0.95/lib/jai_core-1.1.3.jar:fop-0.95/lib/apache-ant-1.8.2.jar"

CURRDIR=$(date +%Y%m%d_%H%M%S)

mkdir "evaluation"/$CURRDIR
### COMPILE_ALL: COMPILES AND CREATES NEW JAR FILES FOR EACH MAINCLASS.
#zsh compile_all.sh
cd evaluation

# ### EXCEUTES ALL THE EXPERIMENTS ON ANTLR
zsh run_eval.sh antlr-2.7.2/antlr $N_ITER $N_ITER_SS "ANTLR" "antlr-2.7.2" $CLASSPATH_ANTLR $CURRDIR


# ### EXCEUTES ALL THE EXPERIMENTS ON FOP
zsh run_eval.sh fop-0.95/src $N_ITER $N_ITER_SS "FOP" "fop-0.95" $CLASSPATH_FOP $CURRDIR


# # ### EXCEUTES ALL THE EXPERIMENTS ON PMD
zsh run_eval.sh pmd-4.2.5/src $N_ITER $N_ITER_SS "PMD" "pmd-4.2.5" $CLASSPATH_PMD $CURRDIR


# ### EXCEUTES ALL THE EXPERIMENTS ON JFREE
zsh run_eval.sh jfreechart-1.0.0/source $N_ITER $N_ITER_SS "JFreeChart" "jfreechart-1.0.0" $CLASSPATH_JFREECHART $CURRDIR
