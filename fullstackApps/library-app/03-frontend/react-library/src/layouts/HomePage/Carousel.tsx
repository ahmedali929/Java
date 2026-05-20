import bookLuv2Code from './../../Images/BooksImages/book-luv2code-1000.png'

export const Carousel = () => {
    return (
        <div className="cointainer mt-5" style={{ height: 550 }}>
            <div className="homepage-carousel-title">
                <h3>Fid your next "I stayed up too late reading" book.</h3>
            </div>
            <div id="carouselExampleControls" className="carousel carousel-dark slide mt-5 d-none d-lg-block" data-bs-interval="false">
                {/*Desktop*/}
                <div className="carousel-inner">
                    <div className="carousel-item active">
                        <div className="row d-flex justify-content-center align-items-center">
                            <div className="col-xs-6 col-sm-6 col-md-4 col-lg-3 mb-3">
                                <div className="text-center">
                                    <img src={bookLuv2Code} width="151" height="233" alt="book" />
                                    <h6 className='mt-2'>Books</h6>
                                    <a className="btn main-color text-white" href="#">Reserve</a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div className="carousel-item">
                        <div className="row d-flex justify-content-center align-items-center">
                            <div className="col-xs-6 col-sm-6 col-md-4 col-lg-3 mb-3">
                                <div className="text-center">
                                    <img src={bookLuv2Code} width="151" height="233" alt="book" />
                                    <h6 className='mt-2'>Books</h6>
                                    <a className="btn main-color text-white" href="#">Reserve</a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div className="carousel-item">
                        <div className="row d-flex justify-content-center align-items-center">
                            <div className="col-xs-6 col-sm-6 col-md-4 col-lg-3 mb-3">
                                <div className="text-center">
                                    <img src={bookLuv2Code} width="151" height="233" alt="book" />
                                    <h6 className='mt-2'>Books</h6>
                                    <a className="btn main-color text-white" href="#">Reserve</a>
                                </div>
                            </div>
                        </div>
                    </div>
                    </div>
                    <button className="carousel-contorl-prev" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="prev">
                        <span className="carosel-contorl-prev-icon" aria-hidden="true"></span>
                        <span className="visually-hidden">Previous</span>
                    </button>
                    <button className="carousel-contorl-next" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="next">
                        <span className="carosel-contorl-next-icon" aria-hidden="true"></span>
                        <span className="visually-hidden">Next</span>
                    </button>
                </div>
                {/* Mobile */}
                <div className="d-lg-node mt-3">
                    <div className="row d-flex justify-content-center align-items-center">
                        <div className="text-center">
                            <img src={bookLuv2Code} width="151" height="233" alt="book" />
                            <h6 className="mt-2">
                                <b>Book</b>
                            </h6>
                            <p>Luv2Code</p>
                            <a className="btn main-color text-wshite" href="#">Reserve</a>
                        </div>
                    </div>   
                </div>
                <div className="homepage-carousel-title mt-3">
                    <a className="btn btn-outline-secondary btn-lg" href="#">View More</a>
                </div>
            </div>
    )
}