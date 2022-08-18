curl http://localhost:8080/api/jsonws/ohqiwtsfhl.h7g5entry/find-by-h_-d_-n \
-u test@liferay.com:test \
-d h7g5FolderId=2022 \
-d description='Test%20Description' \
-d name='Test%20Name'

curl http://localhost:8080/api/jsonws/ohqiwtsfhl.h7g5entry/find-by-h7-g5-folder-id \
-u test@liferay.com:test \
-d h7g5FolderId=2022

curl http://localhost:8080/api/jsonws/ohqiwtsfhl.h7g5entry/find-bykey \
-u test@liferay.com:test \
-d key='key-Test%20Name'

curl http://localhost:8080/api/jsonws/ohqiwtsfhl.h7g5entry/find-by-name \
-u test@liferay.com:test \
-d name='Test%20Name'