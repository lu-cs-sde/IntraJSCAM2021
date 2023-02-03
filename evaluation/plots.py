import matplotlib.pyplot as plt
import numpy as np
import sys
import os
import seaborn as sns
import pandas as pd
import matplotlib.pyplot as plt
import matplotlib.patheffects as path_effects
from pylab import *
from datetime import datetime
from IPython.core.pylabtools import figsize

n = int(sys.argv[1])
project = sys.argv[2]
# print(os.getcwd())
directory = "./"
offset = 4
k = 0
intraj_daa = np.array(sys.argv[(k*n+offset):((k+1)*n+offset)])
intraj_daa = intraj_daa.astype(float)
k += 1
jji_dda = np.array(sys.argv[(k*n+offset):((k+1)*n+offset)])
jji_dda = jji_dda.astype(float)
k += 1
sq_dda = np.array(sys.argv[(k*n+offset):((k+1)*n+offset)])
sq_dda = sq_dda.astype(float)
k += 1
intraj_cfg = np.array(sys.argv[(k*n+offset):((k+1)*n+offset)])
intraj_cfg = intraj_cfg.astype(float)
k += 1
jji_cfg = np.array(sys.argv[(k*n+offset):((k+1)*n+offset)])
jji_cfg = jji_cfg.astype(float)
k += 1
intraj_cfgdaa = np.array(sys.argv[(k*n+offset):((k+1)*n+offset)])
intraj_cfgdaa = intraj_cfgdaa.astype(float)
k += 1
jji_cfgdda = np.array(sys.argv[(k*n+offset):((k+1)*n+offset)])
jji_cfgdda = jji_cfgdda.astype(float)
k += 1
intraj_daa_ss = np.array(sys.argv[(k*n+offset):((k+1)*n+offset)])
intraj_daa_ss = intraj_daa_ss.astype(float)
k += 1
jji_dda_ss = np.array(sys.argv[(k*n+offset):((k+1)*n+offset)])
jji_dda_ss = jji_dda_ss.astype(float)
k += 1
intraj_cfg_ss = np.array(sys.argv[(k*n+offset):((k+1)*n+offset)])
intraj_cfg_ss = intraj_cfg_ss.astype(float)
k += 1
jji_cfg_ss = np.array(sys.argv[(k*n+offset):((k+1)*n+offset)])
jji_cfg_ss = jji_cfg_ss.astype(float)
k += 1
intraj_cfgdaa_ss = np.array(sys.argv[(k*n+offset):((k+1)*n+offset)])
intraj_cfgdaa_ss = intraj_cfgdaa_ss.astype(float)
k += 1
jji_cfgdda_ss = np.array(sys.argv[(k*n+offset):((k+1)*n+offset)])
jji_cfgdda_ss = jji_cfgdda_ss.astype(float)
k += 1
intraj_bl = np.array(sys.argv[(k*n+offset):((k+1)*n+offset)])
intraj_bl = intraj_bl.astype(float)
k += 1
jji_bl = np.array(sys.argv[(k*n+offset):((k+1)*n+offset)])
jji_bl = jji_bl.astype(float)
k += 1
sq_bl = np.array(sys.argv[(k*n+offset):((k+1)*n+offset)])
sq_bl = sq_bl.astype(float)
k += 1
intraj_npa = np.array(sys.argv[(k*n+offset):((k+1)*n+offset)])
intraj_npa = intraj_npa.astype(float)
k += 1
intraj_npa_ss = np.array(sys.argv[(k*n+offset):((k+1)*n+offset)])
intraj_npa_ss = intraj_npa_ss.astype(float)
k += 1
intraj_cfgnpa = np.array(sys.argv[(k*n+offset):((k+1)*n+offset)])
intraj_cfgnpa = intraj_cfgnpa.astype(float)
k += 1
intraj_cfgnpa_ss = np.array(sys.argv[(k*n+offset):((k+1)*n+offset)])
intraj_cfgnpa_ss = intraj_cfgnpa_ss.astype(float)
k += 1
sq_npa = np.array(sys.argv[(k*n+offset):((k+1)*n+offset)])
sq_npa = sq_npa.astype(float)



def setCategories(categories, lines):
    for cat in categories:
        # every 4th line at the interval of 6 is median line
        # 0 -> p25 1 -> p75 2 -> lower whisker 3 -> upper whisker 4 -> p50 5 -> upper extreme value
        y = lines[4+cat*6].get_ydata()[0]
        ax.text(
            cat,
            y,
            '%.3f' % y,
            ha='center',
            va='center',
            fontweight='bold',
            size=10,
            color='white',
            bbox=dict(facecolor='#445A64'))


fig = plt.figure(figsize=(15, 15))
data1 = pd.DataFrame(intraj_daa, columns=['IntraJ']).assign(Location=1)
data2 = pd.DataFrame(
    jji_dda, columns=['JastaddJ-Intraflow']).assign(Location=2)
data3 = pd.DataFrame(
    sq_dda, columns=['SQ']).assign(Location=3)
cdf = pd.concat([data1, data2, data3])
mdf = pd.melt(cdf, id_vars=['Location'], var_name=['Framework'])
ax = sns.boxplot(x="Framework", y="value",  data=mdf)
ax = sns.swarmplot(x="Framework", y="value", data=mdf, color=".25")
ax = ax.axes
ax.set(xlabel='Framework', ylabel='Seconds')
setCategories(ax.get_xticks(), ax.get_lines())
plt.title(project+' - start up - Compting Dead Assignments')
fig.savefig(directory+'/'+project+'_DDA_StartUp.png')
plt.close(fig)

fig = plt.figure(figsize=(15, 15))
data1 = pd.DataFrame(intraj_cfg, columns=['IntraJ']).assign(Location=1)
data2 = pd.DataFrame(
    jji_cfg, columns=['JastaddJ-Intraflow']).assign(Location=2)
cdf = pd.concat([data1, data2])
mdf = pd.melt(cdf, id_vars=['Location'], var_name=['Framework'])
ax = sns.boxplot(x="Framework", y="value",  data=mdf)
ax = sns.swarmplot(x="Framework", y="value", data=mdf, color=".25")
ax = ax.axes
ax.set(xlabel='Framework', ylabel='Seconds')
setCategories(ax.get_xticks(), ax.get_lines())
plt.title(project+' - start up - Visiting all the CFGs')
fig.savefig(directory+'/'+project+'_CFG_StartUp.png')
plt.close(fig)


fig = plt.figure(figsize=(15, 15))
data1 = pd.DataFrame(intraj_cfgdaa, columns=['IntraJ']).assign(Location=1)
data2 = pd.DataFrame(jji_cfgdda, columns=[
                     'JastaddJ-Intraflow']).assign(Location=2)
cdf = pd.concat([data1, data2])
mdf = pd.melt(cdf, id_vars=['Location'], var_name=['Framework'])
ax = sns.boxplot(x="Framework", y="value",  data=mdf)
ax = sns.swarmplot(x="Framework", y="value", data=mdf, color=".25")
ax = ax.axes
ax.set(xlabel='Framework', ylabel='Seconds')
setCategories(ax.get_xticks(), ax.get_lines())
plt.title(project+' - start up - CFG traversing and Dead Assignments')
fig.savefig(directory+'/'+project+'_CFGDDA_StartUp.png')
plt.close(fig)

fig = plt.figure(figsize=(15, 15))
data1 = pd.DataFrame(intraj_daa_ss, columns=['IntraJ']).assign(Location=1)
data2 = pd.DataFrame(jji_dda_ss, columns=[
                     'JastaddJ-Intraflow']).assign(Location=2)
cdf = pd.concat([data1, data2])
mdf = pd.melt(cdf, id_vars=['Location'], var_name=['Framework'])
ax = sns.boxplot(x="Framework", y="value",  data=mdf)
ax = sns.swarmplot(x="Framework", y="value", data=mdf, color=".25")
ax = ax.axes
ax.set(xlabel='Framework', ylabel='Seconds')
setCategories(ax.get_xticks(), ax.get_lines())
plt.title(project+' - stady state - Compting Dead Assignments')
fig.savefig(directory+'/'+project+'_DDA_StadyState.png')
plt.close(fig)

fig = plt.figure(figsize=(15, 15))
data1 = pd.DataFrame(intraj_cfg_ss, columns=['IntraJ']).assign(Location=1)
data2 = pd.DataFrame(jji_cfg_ss, columns=[
                     'JastaddJ-Intraflow']).assign(Location=2)
cdf = pd.concat([data1, data2])
mdf = pd.melt(cdf, id_vars=['Location'], var_name=['Framework'])
ax = sns.boxplot(x="Framework", y="value",  data=mdf)
ax = sns.swarmplot(x="Framework", y="value", data=mdf, color=".25")
ax = ax.axes
ax.set(xlabel='Framework', ylabel='Seconds')
setCategories(ax.get_xticks(), ax.get_lines())
plt.title(project+' - stady state - Visiting all the CFGs')
fig.savefig(directory+'/'+project+'_CFG_StadyState.png')
plt.close(fig)

fig = plt.figure(figsize=(15, 15))
data1 = pd.DataFrame(intraj_cfgdaa_ss, columns=['IntraJ']).assign(Location=1)
data2 = pd.DataFrame(jji_cfgdda_ss, columns=[
                     'JastaddJ-Intraflow']).assign(Location=2)
cdf = pd.concat([data1, data2])
mdf = pd.melt(cdf, id_vars=['Location'], var_name=['Framework'])
ax = sns.boxplot(x="Framework", y="value",  data=mdf)
ax = sns.swarmplot(x="Framework", y="value", data=mdf, color=".25")
ax = ax.axes
ax.set(xlabel='Framework', ylabel='Seconds')
setCategories(ax.get_xticks(), ax.get_lines())
plt.title(project+' - stady state - CFGs Traversing and Dead Assignments')
fig.savefig(directory+'/'+project+'_CFG_CFGDDA_StadyState.png')
plt.close(fig)

fig = plt.figure(figsize=(15, 15))
data1 = pd.DataFrame(intraj_daa, columns=['IntraJ-DAA']).assign(Location=1)
data2 = pd.DataFrame(intraj_cfg, columns=['IntraJ-CFG']).assign(Location=2)
data3 = pd.DataFrame(intraj_cfgdaa, columns=[
                     'IntraJ-CFGDDA']).assign(Location=3)
data4 = pd.DataFrame(jji_dda, columns=['JJI-DAA']).assign(Location=4)
data5 = pd.DataFrame(jji_cfg, columns=['JJI-CFG']).assign(Location=5)
data6 = pd.DataFrame(jji_cfgdda, columns=['JJI-CFGDDA']).assign(Location=6)
cdf = pd.concat([data1, data2, data3, data4, data5, data6])
mdf = pd.melt(cdf, id_vars=['Location'], var_name=['Framework'])
ax = sns.boxplot(x="Framework", y="value",  data=mdf)
ax = sns.swarmplot(x="Framework", y="value", data=mdf, color=".25")
ax = ax.axes
ax.set(xlabel='Framework', ylabel='Seconds')
setCategories(ax.get_xticks(), ax.get_lines())
plt.title(project+' - start up - All')
fig.savefig(directory+'/'+project+'_SUMMARY_StartUp.png')
plt.close(fig)

fig = plt.figure(figsize=(15, 15))
data1 = pd.DataFrame(intraj_daa_ss, columns=['IntraJ-DAA']).assign(Location=1)
data2 = pd.DataFrame(intraj_cfg_ss, columns=['IntraJ-CFG']).assign(Location=2)
data3 = pd.DataFrame(intraj_cfgdaa_ss, columns=[
                     'IntraJ-CFGDDA']).assign(Location=3)
data4 = pd.DataFrame(jji_dda_ss, columns=['JJI-DAA']).assign(Location=4)
data5 = pd.DataFrame(jji_cfg_ss, columns=['JJI-CFG']).assign(Location=5)
data6 = pd.DataFrame(jji_cfgdda_ss, columns=['JJI-CFGDDA']).assign(Location=6)
cdf = pd.concat([data1, data2, data3, data4, data5, data6])
mdf = pd.melt(cdf, id_vars=['Location'], var_name=['Framework'])
ax = sns.boxplot(x="Framework", y="value",  data=mdf)
ax = sns.swarmplot(x="Framework", y="value", data=mdf, color=".25")
ax = ax.axes
ax.set(xlabel='Framework', ylabel='Seconds')
setCategories(ax.get_xticks(), ax.get_lines())
plt.title(project+' - Stady State - All')
fig.savefig(directory+'/'+project+'_SUMMARY_StadyState.png')
plt.close(fig)


fig = plt.figure(figsize=(15, 15))
data1 = pd.DataFrame(intraj_bl, columns=['IntraJ']).assign(Location=1)
data2 = pd.DataFrame(jji_bl, columns=['JastaddJ-Intraflow']).assign(Location=2)
data3 = pd.DataFrame(sq_bl, columns=['SQ']).assign(Location=3)
cdf = pd.concat([data1, data2, data3])
mdf = pd.melt(cdf, id_vars=['Location'], var_name=['Framework'])
ax = sns.boxplot(x="Framework", y="value",  data=mdf)
ax = sns.swarmplot(x="Framework", y="value", data=mdf, color=".25")
ax = ax.axes
ax.set(xlabel='Framework', ylabel='Seconds')
setCategories(ax.get_xticks(), ax.get_lines())
plt.title(project+' - BASELINE')
fig.savefig(directory+'/'+project+'_BASELINE.png')
plt.close(fig)

"${intraj_cfgnpa[@]}" "${intraj_cfgnpa_ss[@]}"

fig = plt.figure(figsize=(15, 15))
data1 = pd.DataFrame(intraj_npa, columns=['IntraJ']).assign(Location=1)
data2 = pd.DataFrame(sq_npa, columns=['SQ']).assign(Location=1)
cdf = pd.concat([data1, data2])
mdf = pd.melt(cdf, id_vars=['Location'], var_name=['Framework'])
ax = sns.boxplot(x="Framework", y="value",  data=mdf)
ax = sns.swarmplot(x="Framework", y="value", data=mdf, color=".25")
ax = ax.axes
ax.set(xlabel='Framework', ylabel='Seconds')
setCategories(ax.get_xticks(), ax.get_lines())
plt.title(project+' - NPA - Start Up')
fig.savefig(directory+'/'+project+'_NPA.png')
plt.close(fig)

fig = plt.figure(figsize=(15, 15))
data1 = pd.DataFrame(intraj_npa_ss, columns=['IntraJ']).assign(Location=1)
cdf = pd.concat([data1])
mdf = pd.melt(cdf, id_vars=['Location'], var_name=['Framework'])
ax = sns.boxplot(x="Framework", y="value",  data=mdf)
ax = sns.swarmplot(x="Framework", y="value", data=mdf, color=".25")
ax = ax.axes
ax.set(xlabel='Framework', ylabel='Seconds')
setCategories(ax.get_xticks(), ax.get_lines())
plt.title(project+' - NPA - Stady State')
fig.savefig(directory+'/'+project+'_NPA_StadyState.png')
plt.close(fig)

fig = plt.figure(figsize=(15, 15))
data1 = pd.DataFrame(intraj_cfgnpa, columns=['IntraJ']).assign(Location=1)
cdf = pd.concat([data1])
mdf = pd.melt(cdf, id_vars=['Location'], var_name=['Framework'])
ax = sns.boxplot(x="Framework", y="value",  data=mdf)
ax = sns.swarmplot(x="Framework", y="value", data=mdf, color=".25")
ax = ax.axes
ax.set(xlabel='Framework', ylabel='Seconds')
setCategories(ax.get_xticks(), ax.get_lines())
plt.title(project+' - CFGs Traversing and NPA - Start Up')
fig.savefig(directory+'/'+project+'_CFGNPA.png')
plt.close(fig)

fig = plt.figure(figsize=(15, 15))
data1 = pd.DataFrame(intraj_cfgnpa_ss, columns=['IntraJ']).assign(Location=1)
cdf = pd.concat([data1])
mdf = pd.melt(cdf, id_vars=['Location'], var_name=['Framework'])
ax = sns.boxplot(x="Framework", y="value",  data=mdf)
ax = sns.swarmplot(x="Framework", y="value", data=mdf, color=".25")
ax = ax.axes
ax.set(xlabel='Framework', ylabel='Seconds')
setCategories(ax.get_xticks(), ax.get_lines())
plt.title(project+' - CFGs Traversing and NPA - Stady State')
fig.savefig(directory+'/'+project+'_CFGNPA_StadyState.png')
plt.close(fig)
