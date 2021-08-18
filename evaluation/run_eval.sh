#!/bin/zsh

# Author: Idriss Riouak 
# Date: 29/01/2021
# E-mail: idriss.riouak@cs.lth.se

### Setting the environment
# . ~/.sdkman/bin/sdkman-init.sh
# sdk use java 7.0.292-zulu
set -e

TIMEFMT=$'U'
TEST_DIR=$1
FILES=($TEST_DIR/**/*.java)
N_ITER=$2
N_ITER_SS=$3
PROJECT=$4
CLASSPATH=$5


alias INTRAJ="java  -jar  ../intraj.jar -classpath "$CLASSPATH
alias INTRAJ_BL="java  -jar  ../intraj_bl.jar -classpath "$CLASSPATH
alias INTRAJ_DDA="java  -jar  ../intraj_daa.jar -classpath "$CLASSPATH
alias INTRAJ_CFG="java  -jar  ../intraj_cfg.jar -classpath "$CLASSPATH
alias INTRAJ_CFGDDA="java  -jar  ../intraj_cfgdaa.jar -classpath "$CLASSPATH
alias JJI_BL="java  -cp jastaddj-intraflow/:jastaddj-intraflow/bin:jastaddj-intraflow/jastaddj/tools/beaver-rt.jar org.jastadd.jastaddj.flow.JJI -classpath "$CLASSPATH
alias JJI_DDA="java  -cp jastaddj-intraflow/:jastaddj-intraflow/bin:jastaddj-intraflow/jastaddj/tools/beaver-rt.jar org.jastadd.jastaddj.flow.JJI_DDA -classpath "$CLASSPATH
alias JJI_CFG="java  -cp jastaddj-intraflow/:jastaddj-intraflow/bin:jastaddj-intraflow/jastaddj/tools/beaver-rt.jar org.jastadd.jastaddj.flow.JJI_CFG -classpath "$CLASSPATH
alias JJI_CFGDDA="java  -cp jastaddj-intraflow/:jastaddj-intraflow/bin:jastaddj-intraflow/jastaddj/tools/beaver-rt.jar org.jastadd.jastaddj.flow.JJI_CFGDDA -classpath "$CLASSPATH


echo '\u001b[33;1m[INFO] Running Time performance evaluation (INTRAJ_DDA) \u001b[0m'
export intraj_daa=()
for a in {1..$N_ITER}
do
 sleep 1
 START=$(gdate +%s.%N)
 (INTRAJ_DDA $FILES)
 END=$(gdate +%s.%N)
 PROC_TIME=$(echo "$END - $START" | bc)
 echo $DIFF
 echo "\u001b[34;1m--------Iteration "$a" -------->>  Time: "$PROC_TIME"s\u001b[0m"
 intraj_daa+=($PROC_TIME)
done

echo '\u001b[33;1m[INFO] Running Time performance evaluation  (INTRAJ_DDA) '$N_ITER_SS' iters \u001b[0m'
export intraj_daa_ss=()
for a in {1..$N_ITER}
do
 START=$(gdate +%s.%N)
 RESULT=$(INTRAJ_DDA $FILES -niter=$N_ITER_SS)
 END=$(gdate +%s.%N)
 PROC_TIME=$(echo "$END - $START" | bc)
 echo $DIFF
 echo "\u001b[34;1m--------Iteration "$a" -------->>  Time: "$RESULT"s\u001b[0m"
 intraj_daa_ss+=($RESULT)
done

############################

echo '\u001b[33;1m[INFO] Running Time performance evaluation (INTRAJ_CFG) \u001b[0m'
export intraj_cfg=()
for a in {1..$N_ITER}
do
 sleep 1
 START=$(gdate +%s.%N)
 (INTRAJ_CFG $FILES )
 END=$(gdate +%s.%N)
 PROC_TIME=$(echo "$END - $START" | bc)
 echo $DIFF
 echo "\u001b[34;1m--------Iteration "$a" -------->>  Time: "$PROC_TIME"s\u001b[0m"
 intraj_cfg+=($PROC_TIME)
done

echo '\u001b[33;1m[INFO] Running Time performance evaluation  (INTRAJ_CFG) '$N_ITER_SS' iters \u001b[0m'
export intraj_cfg_ss=()
for a in {1..$N_ITER}
do
 START=$(gdate +%s.%N)
 RESULT=$(INTRAJ_CFG $FILES -niter=$N_ITER_SS)
 END=$(gdate +%s.%N)
 PROC_TIME=$(echo "$END - $START" | bc)
 echo $DIFF
 echo "\u001b[34;1m--------Iteration "$a" -------->>  Time: "$RESULT"s\u001b[0m"
 intraj_cfg_ss+=($RESULT)
done

##########################

echo '\u001b[33;1m[INFO] Running Time performance evaluation (INTRAJ_CFGDDA) \u001b[0m'
export intraj_cfgdaa=()
for a in {1..$N_ITER}
do
 sleep 1
 START=$(gdate +%s.%N)
 (INTRAJ_CFGDDA $FILES)
 END=$(gdate +%s.%N)
 PROC_TIME=$(echo "$END - $START" | bc)
 echo $DIFF
 echo "\u001b[34;1m--------Iteration "$a" -------->>  Time: "$PROC_TIME"s\u001b[0m"
 intraj_cfgdaa+=($PROC_TIME)
done

echo '\u001b[33;1m[INFO] Running Time performance evaluation (INTRAJ_CFGDDA) '$N_ITER_SS' iters \u001b[0m'
export intraj_cfgdaa_ss=()
for a in {1..$N_ITER}
do
 START=$(gdate +%s.%N)
 RESULT=$(INTRAJ_CFGDDA $FILES -niter=$N_ITER_SS)
 END=$(gdate +%s.%N)
 PROC_TIME=$(echo "$END - $START" | bc)
 echo $DIFF
 echo "\u001b[34;1m--------Iteration "$a" -------->>  Time: "$RESULT"s\u001b[0m"
 intraj_cfgdaa_ss+=($RESULT)
done


echo '\u001b[33;1m[INFO] Results DAA (start up)'$N_ITER_SS' iters \u001b[0m'
echo $intraj_daa
echo '\u001b[33;1m[INFO] Results DAA (stady state)'$N_ITER_SS' iters \u001b[0m'
echo $intraj_daa_ss
echo '\u001b[33;1m[INFO] Results CFG (start up)'$N_ITER_SS' iters \u001b[0m'
echo $intraj_cfg
echo '\u001b[33;1m[INFO] Results CFG (stady state)'$N_ITER_SS' iters \u001b[0m'
echo $intraj_cfg_ss
echo '\u001b[33;1m[INFO] Results CFGDDA (start up)'$N_ITER_SS' iters \u001b[0m'
echo $intraj_cfgdaa
echo '\u001b[33;1m[INFO] Results CFGDDA (stady state)'$N_ITER_SS' iters \u001b[0m'
echo $intraj_cfgdaa_ss


echo '\u001b[33;1m[INFO] Running Time performance evaluation (JJI_DDA) \u001b[0m'
export jji_dda=()
for a in {1..$N_ITER}
do
 sleep 1
 START=$(gdate +%s.%N)
 (JJI_DDA $FILES )
 END=$(gdate +%s.%N)
 PROC_TIME=$(echo "$END - $START" | bc)
 echo $DIFF
 echo "\u001b[34;1m--------Iteration "$a" -------->>  Time: "$PROC_TIME"s\u001b[0m"
 jji_dda+=($PROC_TIME)
done

echo '\u001b[33;1m[INFO] Running Time performance evaluation (JJI_DDA) '$N_ITER_SS' iters \u001b[0m'
export jji_dda_ss=()
for a in {1..$N_ITER}
do
 START=$(gdate +%s.%N)
 RESULT=$(JJI_DDA $FILES -niter=$N_ITER_SS)
 END=$(gdate +%s.%N)
 PROC_TIME=$(echo "$END - $START" | bc)
 echo $DIFF
 echo "\u001b[34;1m--------Iteration "$a" -------->>  Time: "$RESULT"s\u001b[0m"
 jji_dda_ss+=($RESULT)
done

############################

echo '\u001b[33;1m[INFO] Running Time performance evaluation (JJI_CFG) \u001b[0m'
export jji_cfg=()
for a in {1..$N_ITER}
do
 sleep 1
 START=$(gdate +%s.%N)
 (JJI_CFG $FILES )
 END=$(gdate +%s.%N)
 PROC_TIME=$(echo "$END - $START" | bc)
 echo $DIFF
 echo "\u001b[34;1m--------Iteration "$a" -------->>  Time: "$PROC_TIME"s\u001b[0m"
 jji_cfg+=($PROC_TIME)
done

echo '\u001b[33;1m[INFO] Running Time performance evaluation (JJI_CFG)'$N_ITER_SS' iters \u001b[0m'
export jji_cfg_ss=()
for a in {1..$N_ITER}
do
 START=$(gdate +%s.%N)
 RESULT=$(JJI_CFG $FILES  -niter=$N_ITER_SS)
 END=$(gdate +%s.%N)
 PROC_TIME=$(echo "$END - $START" | bc)
 echo $DIFF
 echo "\u001b[34;1m--------Iteration "$a" -------->>  Time: "$RESULT"s\u001b[0m"
 jji_cfg_ss+=($RESULT)
done

##########################

echo '\u001b[33;1m[INFO] Running Time performance evaluation (JJI_CFGDDA) \u001b[0m'
export jji_cfgdda=()
for a in {1..$N_ITER}
do
 sleep 1
 START=$(gdate +%s.%N)
 (JJI_CFGDDA $FILES )
 END=$(gdate +%s.%N)
 PROC_TIME=$(echo "$END - $START" | bc)
 echo $DIFF
 echo "\u001b[34;1m--------Iteration "$a" -------->>  Time: "$PROC_TIME"s\u001b[0m"
 jji_cfgdda+=($PROC_TIME)
done

echo '\u001b[33;1m[INFO] Running Time performance evaluation (JJI_CFGDDA) '$N_ITER_SS' iters \u001b[0m'
export jji_cfgdda_ss=()
for a in {1..$N_ITER}
do
 START=$(gdate +%s.%N)
 RESULT=$(JJI_CFGDDA $FILES  -niter=$N_ITER_SS)
 END=$(gdate +%s.%N)
 PROC_TIME=$(echo "$END - $START" | bc)
 echo $DIFF
 echo "\u001b[34;1m--------Iteration "$a" -------->>  Time: "$RESULT"s\u001b[0m"
 jji_cfgdda_ss+=($RESULT)
done


echo '\u001b[33;1m[INFO] Results JJI_DDA (start up)'$N_ITER_SS' iters \u001b[0m'
echo $jji_dda
echo '\u001b[33;1m[INFO] Results JJI_DDA (stady state)'$N_ITER_SS' iters \u001b[0m'
echo $jji_dda_ss
echo '\u001b[33;1m[INFO] Results JJI_CFG (start up)'$N_ITER_SS' iters \u001b[0m'
echo $jji_cfg
echo '\u001b[33;1m[INFO] Results JJI_CFG (stady state)'$N_ITER_SS' iters \u001b[0m'
echo $jji_cfg_ss
echo '\u001b[33;1m[INFO] Results JJI_CFGDDA (start up)'$N_ITER_SS' iters \u001b[0m'
echo $jji_cfgdda
echo '\u001b[33;1m[INFO] Results JJI_CFGDDA (stady state)'$N_ITER_SS' iters \u001b[0m'
echo $jji_cfgdda_ss



echo '\u001b[33;1m[INFO] Running Time performance evaluation (INTRAJ_BL) \u001b[0m'
export intraj_bl=()
for a in {1..$N_ITER}
do
 sleep 1
 START=$(gdate +%s.%N)
 (INTRAJ_BL $FILES )
 END=$(gdate +%s.%N)
 PROC_TIME=$(echo "$END - $START" | bc)
 echo $DIFF
 echo "\u001b[34;1m--------Iteration "$a" -------->>  Time: "$PROC_TIME"s\u001b[0m"
 intraj_bl+=($PROC_TIME)
done


echo '\u001b[33;1m[INFO] Running Time performance evaluation (JJI_BL) \u001b[0m'
export jji_bl=()
for a in {1..$N_ITER}
do
 sleep 1
 START=$(gdate +%s.%N)
 (JJI_BL $FILES )
 END=$(gdate +%s.%N)
 PROC_TIME=$(echo "$END - $START" | bc)
 echo $DIFF
 echo "\u001b[34;1m--------Iteration "$a" -------->>  Time: "$PROC_TIME"s\u001b[0m"
 jji_bl+=($PROC_TIME)
done


CURRDIR=$(date +%Y%m%d_%H%M%S)
mkdir $CURRDIR
cd $CURRDIR

# python3 plots.py $N_ITER $PROJECT "${intraj_daa[@]}" "${jji_dda[@]}"
python3 ../plots.py $N_ITER $PROJECT $CURRDIR "${intraj_daa[@]}" "${jji_dda[@]}"  "${intraj_cfg[@]}" "${jji_cfg[@]}" "${intraj_cfgdaa[@]}" "${jji_cfgdda[@]}" "${intraj_daa_ss[@]}" "${jji_dda_ss[@]}"  "${intraj_cfg_ss[@]}" "${jji_cfg_ss[@]}" "${intraj_cfgdaa_ss[@]}" "${jji_cfgdda_ss[@]}" "${intraj_bl[@]}" "${jji_bl[@]}"
cd ..


INTRAJ $FILES -WDAA -statistics > $CURRDIR"/INTRAJ_NH_DAA"
INTRAJ $FILES -WDAA -statistics -excludelit > $CURRDIR"/INTRAJ_H_DAA"
INTRAJ $FILES -WNPA -statistics > $CURRDIR"/INTRAJ_NPA"




