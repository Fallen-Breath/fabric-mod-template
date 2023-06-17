"""
A script to scan through the versions directory and collect all folder names as the subproject list,
then output a json as the github action include matrix
"""
__author__ = 'Fallen_Breath'

import json
import os
import sys


def main():
	target_subproject = os.environ.get('TARGET_SUBPROJECT')
	with open('settings.json') as f:
		settings: dict = json.load(f)

	if target_subproject is None:
		subprojects = settings['versions']
	else:
		subprojects = list(filter(None, target_subproject.split(',')))
		for subproject in subprojects:
			if subproject not in settings['versions']:
				print('Unexpected input subproject {}'.format(subproject), file=sys.stderr)
				sys.exit(1)

	items = [{'subproject': subproject} for subproject in subprojects]
	result = {'include': items}
	with open(os.environ['GITHUB_OUTPUT'], 'w') as f:
		f.write('matrix={}\n'.format(json.dumps(result)))


if __name__ == '__main__':
	main()
