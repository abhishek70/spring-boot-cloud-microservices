import { API_BASE_URL,
        ACCESS_TOKEN,
        SIGNIN_SERVICE_SERVER_ERROR,
        SIGNIN_SERVICE_AUTH_ERROR,
        ERROR
} from '../constants';

export const signInService = (data) => {

    let params = {
        'grant_type': 'password',
        'username': data.username,
        'password': data.password
    };

    let formBody = [];
    for (let property in params) {
        let encodedKey = encodeURIComponent(property);
        let encodedValue = encodeURIComponent(params[property]);
        formBody.push(encodedKey + "=" + encodedValue);
    }
    formBody = formBody.join("&");

    let options = {
        method: 'POST',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded',
            'Authorization': 'Basic cmVhY3Q6cmVhY3Q='
        },
        body: formBody
    };

    return fetch(API_BASE_URL+'/oauth/token',options)
                .then(response =>
                    response.json().then(json => {
                                            if (!response.ok) {
                                                return {"status":ERROR, "message":SIGNIN_SERVICE_AUTH_ERROR};
                                            }

                                            localStorage.setItem(ACCESS_TOKEN, json.access_token);

                                            return json;
                                        })
                ).then(data => {
                    return data;
                })
                .catch(error => {
                    return {"status":ERROR, "message":SIGNIN_SERVICE_SERVER_ERROR};
                });
};