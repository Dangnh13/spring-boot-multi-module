var messages = new Array();
messages["C0001"] = "登録します。よろしいですか？";
messages["C0002"] = "削除します。よろしいですか？";
messages["C0003"] = "更新します。よろしいですか？";
messages["C0004"] = "変更します。よろしいですか？";
messages["C0005"] = "取消します。よろしいですか？";
messages["C0006"] = "%{0}を%{1}します。よろしいですか？";
messages["C0007"] = "入力内容が未登録です。画面遷移すると破棄されますがよろしいですか？";
messages["C0008"] = "%{0}で使用されていますがよろしいですか？";
messages["C0009"] = "%{0}します。よろしいですか？";
messages["C0010"] = "";
messages["C0011"] = "";
messages["C0012"] = "";
messages["C0013"] = "画面で更新して、登録していない情報は、破棄します。よろしいですか？";
messages["W0001"] = "一括退会する利用者を選択してください。";


function getMsg(id) {
	var str = "";
	if ( messages[ id ] != undefined ) {
		str = messages[ id ];
	}
	return str;
}

function getMsgWithParams(id, params) {
	var fmt = "";
	if ( messages[ id ] != undefined ) {
		fmt = messages[ id ];
		return fmt.replace(/%{(.*?)}/g, function($0, $1) {
			return ( params[$1] && typeof(params[$1]) != "object" ) ? params[$1].toString() : JSON.stringify(params[$1]);
		});
	}
	return fmt;
}
