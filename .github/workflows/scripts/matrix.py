"""
A script to scan through the versions directory and collect all folder names as the subproject list,
then output a json as the github action include matrix
"""
__author__ = 'Fallen_Breath'

import json
import os
import sys


def main():
	target_subproject_env = os.environ.get('TARGET_SUBPROJECT', '')
	target_subprojects = set(target_subproject_env.split(',')) if target_subproject_env != '' else set()
	with open('settings.json') as f:
		settings: dict = json.load(f)

	if len(target_subprojects) == 0:
		subprojects = settings['versions']
	else:
		subprojects = []
		for subproject in settings['versions']:
			if subproject in target_subprojects:
				subprojects.append(subproject)
				target_subprojects.remove(subproject)
		if len(target_subprojects) > 0:
			print('Unexpected subprojects: {}'.format(target_subprojects), file=sys.stderr)
			sys.exit(1)

	items = [{'subproject': subproject} for subproject in subprojects]
	result = {'include': items}
	with open(os.environ['GITHUB_OUTPUT'], 'w') as f:
		f.write('matrix={}\n'.format(json.dumps(result)))


if __name__ == '__main__':
	main()
