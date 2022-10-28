package com.example.project_221024.ifs;

import com.example.project_221024.network.Header;

public interface CrudInterface<Req, Res> {

    Header<Res> create(Header<Req> request);
    Header<Res> read(Long id);
    Header<Res> update(Header<Req> request);
    Header delete(Long id);

}
