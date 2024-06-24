function solution(new_id) {
    return new Id(new_id)
        .stage1()
        .stage2()
        .stage3()
        .stage4()
        .stage5()
        .stage6()
        .stage7()
        .toString();
}

function Id(input){
    this.id = input;
    
    Id.prototype.stage1 = function () {
        this.id = this.id.toLowerCase();
        return this;    
    }
    
    Id.prototype.stage2 = function () {
        this.id = this.id.match(/[a-z0-9-_.]/g).join("");
        return this;
    }
    
    Id.prototype.stage3 = function () {
        this.id = this.id.replace(/\.+/g, '.');
        return this;
    }
    
    Id.prototype.stage4 = function () {
        if(this.id.startsWith('.'))
            this.id = this.id.slice(1);
        return this;
    }
    
    Id.prototype.stage5 = function () {
        if(this.id.length === 0)
            this.id = "a";
        return this;
    }
    
    Id.prototype.stage6 = function () {
        if(this.id.length >= 16)
            this.id = this.id.slice(0, 15);
        if(this.id.endsWith('.'))
            this.id = this.id.slice(0, -1);
        return this;
    }
    
    Id.prototype.stage7 = function () {
        let len = this.id.length;
        while(++len <= 3){
            this.id += this.id.slice(-1);
        }
        
        return this;
    }
    
    Id.prototype.toString = function () {
        return this.id;
    }
}

// 체이닝 메서드를 사용한 이유 : 단위 테스트가 편하다. 가독성이 좋다.
// 개선점 : this.id의 불필요한 반복을 줄일 수 없을까.
